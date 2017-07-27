package com.lefinance.regulation.service;

import com.lefinance.common.constant.RegulatoryContants;
import com.lefinance.common.constant.TransEnum;
import com.lefinance.common.utils.CommonUtil;
import com.lefinance.common.utils.PubMethod;
import com.lefinance.regulation.dao.RegCqNetbookInfoMapper;
import com.lefinance.regulation.domain.RegCqNetbookInfo;
import com.lefinance.regulation.model.ptln107.NetbookInfo;
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
 * @Time: 2017/7/4 12:00
 * @Describe:
 */
@Service("ptln107Service")
public class PTLN107Service extends DataPushBaseService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private RegCqNetbookInfoMapper regCqNetbookInfoMapper;
    @Resource
    private AcctCreateKeyService acctCreateKeyService;
    @Resource
    private RegCqFileService regCqFileService;
    @Resource
    private RegCqFileLogService regCqFileLogService;

    /**
     * @Author: jingyan
     * @Time: 2017/7/4 14:48
     * @Describe: 锁定数据
     */
    @Override
    public String lockData() {
        RegCqNetbookInfo record = new RegCqNetbookInfo();
        record.setStatus(RegulatoryContants.DataStatus.UNREPORT);
        record.setRetryNum(dataPushConfig.getRetryNum());
        record.setIsSuccess(false);
        List<RegCqNetbookInfo> dataList = regCqNetbookInfoMapper.selectBatchForUpload(record);
        if (PubMethod.isEmpty(dataList)) {
            logger.info("数据锁定---107未查询到数据...");
            return null;
        }
        String batchGid = CommonUtil.getUUIDWithoutSeparator();
        //更新合同表数据状态,锁住这批数据
        this.updateRegCqNetbookInfo(dataList, RegulatoryContants.DataStatus.REPORTING, batchGid);
        return batchGid;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/7/4 14:51
     * @Describe: 解锁数据
     */
    @Override
    public String unlockData(String batchGid, int status) {
        RegCqNetbookInfo record = new RegCqNetbookInfo();
        record.setBatchGid(batchGid);
        record.setStatus(status);
        record.setUpdateTime(new Date());
        record.setUpdateUser("SYSTEM");
        if (RegulatoryContants.DataStatus.REPORTED == status) {
            record.setIsSuccess(true);
        } else {
            record.setIsSuccess(false);
        }
        this.regCqNetbookInfoMapper.updateByBatchGid(record);
        return batchGid;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/7/4 15:31
     * @Describe: 生成文件
     */
    @Override
    public String crearteFile(String batchGid) {
        //查询批次数据详情
        List<RegCqNetbookInfo> dataList = regCqNetbookInfoMapper.selectByBatchGid(batchGid);
        if (PubMethod.isEmpty(dataList)) {
            return null;
        }
        //生成文件
        String fileNo = acctCreateKeyService.createFileSequence(RegulatoryContants.FileSequence.REDIS_CACHE_FILE_107_SEQUENCE);
        if (PubMethod.isEmpty(fileNo)) {
            logger.info("生成上报文件---获取文件编号为空：PTLN107");
            return null;
        }
        String filename = this.createLocalFile(this.convert(dataList), TransEnum.PTLN107, batchGid, fileNo);
        logger.info("生成上报文件---filename={}", filename);
        //插入文件表
        this.regCqFileService.saveCqFileInfo(TransEnum.PTLN107, batchGid, filename, dataList.size());
        //插入日志表
        this.regCqFileLogService.insert(batchGid, Boolean.TRUE, RegulatoryContants.LogRemark.LOCK_DATA);
        return filename;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/7/4 14:49
     * @Describe: 更新数据
     */
    public void updateRegCqNetbookInfo(List<RegCqNetbookInfo> dataList, Integer status, String batchGid) {
        for (RegCqNetbookInfo netbookInfo : dataList) {
            netbookInfo.setStatus(status);
            netbookInfo.setBatchGid(batchGid);
            netbookInfo.setRetryNum(netbookInfo.getRetryNum() + 1);
            netbookInfo.setReportTime(new Date());
            this.regCqNetbookInfoMapper.updateByPrimaryKeySelective(netbookInfo);
        }
    }

    /**
     * @Author: jingyan
     * @Time: 2017/7/4 15:32
     * @Describe: 组装数据
     */
    private List<NetbookInfo> convert(List<RegCqNetbookInfo> dataList) {
        List<NetbookInfo> list = new ArrayList<>();
        if (PubMethod.isEmpty(dataList)) {
            return list;
        }
        for (RegCqNetbookInfo data : dataList) {
            NetbookInfo info = new NetbookInfo();
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
    public int saveBusinessDate(RegCqNetbookInfo record) {
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        record.setCreateUser("SYSTEM");
        record.setUpdateUser("SYSTEM");
        record.setIsSuccess(false);
        record.setRetryNum(0);
        record.setStatus(RegulatoryContants.DataStatus.UNREPORT);
        record.setReportTime(new Date());
        record.setOrgCode(dataPushConfig.getLocalBranchId());
        logger.info("107业务数据入库：" + record.toString());
        return regCqNetbookInfoMapper.insert(record);
    }
}

