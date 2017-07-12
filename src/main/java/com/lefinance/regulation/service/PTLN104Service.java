package com.lefinance.regulation.service;

import com.lefinance.common.constant.RegulatoryContants;
import com.lefinance.common.constant.TransEnum;
import com.lefinance.common.utils.CommonUtils;
import com.lefinance.common.utils.PubMethod;
import com.lefinance.regulation.dao.RegCqRepayInfoMapper;
import com.lefinance.regulation.domain.RegCqRepayInfo;
import com.lefinance.regulation.model.ptln104.RepayInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: jingyan
 * @Time: 2017/6/28 18:07
 * @Describe: 贷款还款上报
 */
@Service("ptln104Service")
public class PTLN104Service extends DataPushBaseService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private RegCqRepayInfoMapper regCqRepayInfoMapper;
    @Resource
    private AcctCreateKeyService acctCreateKeyService;
    @Resource
    private RegCqFileService regCqFileService;
    @Resource
    private RegCqFileLogService regCqFileLogService;

    /**
     * @Author: jingyan
     * @Time: 2017/6/28 18:19
     * @Describe: 批量锁定数据
     */
    @Override
    public String lockData() {
        RegCqRepayInfo record = new RegCqRepayInfo();
        record.setStatus(RegulatoryContants.DataStatus.UNREPORT);
        record.setRetryNum(dataPushConfig.getRetryNum());
        record.setIsSuccess(false);
        List<RegCqRepayInfo> dataList = regCqRepayInfoMapper.selectBatchForUpload(record);
        if (PubMethod.isEmpty(dataList)) {
            logger.info("数据锁定---104未查询到数据...");
            return null;
        }
        String batchGid = CommonUtils.getUUIDWithoutSeparator();
        this.updateRegCqIssueInfo(dataList, RegulatoryContants.DataStatus.REPORTING, batchGid);
        return batchGid;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/28 18:20
     * @Describe: 批量解锁数据
     */
    @Override
    public String unlockData(String batchGid, int status) {
        RegCqRepayInfo record = new RegCqRepayInfo();
        record.setBatchGid(batchGid);
        record.setStatus(status);
        record.setUpdateTime(new Date());
        record.setUpdateUser("SYSTEM");
        if (RegulatoryContants.DataStatus.REPORTED == status) {
            record.setIsSuccess(true);
        }else {
            record.setIsSuccess(Boolean.FALSE);
        }
        regCqRepayInfoMapper.updateByBatchGid(record);
        return batchGid;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/28 18:20
     * @Describe: 创建上报文件
     */
    @Override
    public String crearteFile(String batchGid) {
        List<RegCqRepayInfo> dataList = regCqRepayInfoMapper.selectByBatchGid(batchGid);
        if (PubMethod.isEmpty(dataList)) {
            return null;
        }
        //生成文件
        String fileNo = acctCreateKeyService.createFileSequence(RegulatoryContants.FileSequence.REDIS_CACHE_FILE_104_SEQUENCE);
        if (PubMethod.isEmpty(fileNo)) {
            logger.info("生成上报文件---获取文件编号为空：PTLN103");
            return null;
        }
        String filename = this.createLocalFile(this.convert(dataList), TransEnum.PTLN104, batchGid, fileNo);
        logger.info("生成上报文件---filename={}", filename);
        //插入文件表
        this.regCqFileService.saveCqFileInfo(TransEnum.PTLN104, batchGid, filename, dataList.size());
        //插入日志表
        this.regCqFileLogService.insert(batchGid, Boolean.TRUE, RegulatoryContants.LogRemark.LOCK_DATA);
        return filename;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/27 17:40
     * @Describe: 更新表状态
     */
    public void updateRegCqIssueInfo(List<RegCqRepayInfo> dataList, Integer status, String batchGid) {
        for (RegCqRepayInfo record : dataList) {
            record.setStatus(status);
            record.setBatchGid(batchGid);
            record.setRetryNum(record.getRetryNum() + 1);
            this.regCqRepayInfoMapper.updateByPrimaryKeySelective(record);
        }
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/29 14:15
     * @Describe: 组装数据
     */
    private List<RepayInfo> convert(List<RegCqRepayInfo> dataList) {
        List<RepayInfo> list = new ArrayList<>();
        if (PubMethod.isEmpty(dataList)) {
            return list;
        }
        for (RegCqRepayInfo data : dataList) {
            RepayInfo info = new RepayInfo();
            BeanUtils.copyProperties(data, info);
            list.add(info);
        }
        return list;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/30 18:30
     * @Describe: 业务数据入库
     */
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class}, propagation = Propagation.REQUIRES_NEW)
    public int saveBusinessDate(RegCqRepayInfo record) {
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        record.setCreateUser("SYSTEM");
        record.setUpdateUser("SYSTEM");
        record.setIsSuccess(false);
        record.setRetryNum(0);
        record.setStatus(RegulatoryContants.DataStatus.UNREPORT);
        record.setReportTime(new Date());
        record.setOrgCode(dataPushConfig.getLocalBranchId());
        logger.info("104业务数据入库：" + record.toString());
        return regCqRepayInfoMapper.insert(record);
    }
}
