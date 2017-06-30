package com.lefinance.regulation.service;

import com.lefinance.common.constant.RegulatoryContants;
import com.lefinance.common.constant.TransEnum;
import com.lefinance.common.utils.CommonUtils;
import com.lefinance.common.utils.PubMethod;
import com.lefinance.regulation.dao.RegCqPayplanInfoMapper;
import com.lefinance.regulation.domain.RegCqPayplanInfo;
import com.lefinance.regulation.model.ptln105.PayplanInfo;
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
 * @Describe: 还款计划上报
 */
@Service("ptln105Service")
public class PTLN105Service extends DataPushBaseService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private RegCqPayplanInfoMapper regCqPayplanInfoMapper;
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
        RegCqPayplanInfo record = new RegCqPayplanInfo();
        record.setStatus(RegulatoryContants.DataStatus.UNREPORT);
        record.setRetryNum(dataPushConfig.getRetryNum());
        record.setIsSuccess(false);
        List<RegCqPayplanInfo> dataList = regCqPayplanInfoMapper.selectBatchForUpload(record);
        if (PubMethod.isEmpty(dataList)) {
            logger.info("数据锁定---105未查询到数据...");
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
        RegCqPayplanInfo record = new RegCqPayplanInfo();
        record.setBatchGid(batchGid);
        record.setStatus(status);
        record.setUpdateTime(new Date());
        record.setUpdateUser("SYSTEM");
        if (RegulatoryContants.DataStatus.REPORTED == status) {
            record.setIsSuccess(true);
        }
        regCqPayplanInfoMapper.updateByBatchGid(record);
        return batchGid;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/28 18:20
     * @Describe: 创建上报文件
     */
    @Override
    public String crearteFile(String batchGid) {
        List<RegCqPayplanInfo> dataList = regCqPayplanInfoMapper.selectByBatchGid(batchGid);
        if (PubMethod.isEmpty(dataList)) {
            return null;
        }
        //生成文件
        String fileNo = acctCreateKeyService.createFileSequence(RegulatoryContants.FileSequence.REDIS_CACHE_FILE_105_SEQUENCE);
        if (PubMethod.isEmpty(fileNo)) {
            logger.info("生成上报文件---获取文件编号为空：PTLN103");
            return null;
        }
        String filename = this.createLocalFile(this.convert(dataList), TransEnum.PTLN105, batchGid, fileNo);
        logger.info("生成上报文件---filename={}", filename);
        //插入文件表
        this.regCqFileService.saveCqFileInfo(TransEnum.PTLN105, batchGid, filename, dataList.size());
        //插入日志表
        this.regCqFileLogService.insert(batchGid, Boolean.TRUE, RegulatoryContants.LogRemark.LOCK_DATA);
        return filename;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/27 17:40
     * @Describe: 更新表状态
     */
    public void updateRegCqIssueInfo(List<RegCqPayplanInfo> dataList, Integer status, String batchGid) {
        for (RegCqPayplanInfo record : dataList) {
            record.setStatus(status);
            record.setBatchGid(batchGid);
            record.setRetryNum(record.getRetryNum() + 1);
            this.regCqPayplanInfoMapper.updateByPrimaryKeySelective(record);
        }
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/29 14:18
     * @Describe: 组装数据
     */
    private List<PayplanInfo> convert(List<RegCqPayplanInfo> dataList) {
        List<PayplanInfo> list = new ArrayList<>();
        if (PubMethod.isEmpty(dataList)) {
            return list;
        }
        for (RegCqPayplanInfo data : dataList) {
            PayplanInfo info = new PayplanInfo();
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
    public int saveBusinessDate(RegCqPayplanInfo record) {
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        record.setCreateUser("SYSTEM");
        record.setUpdateUser("SYSTEM");
        record.setIsSuccess(false);
        record.setRetryNum(0);
        record.setStatus(RegulatoryContants.DataStatus.UNREPORT);
        record.setReportTime(new Date());
        logger.info("105业务数据入库：" + record.toString());
        return regCqPayplanInfoMapper.insert(record);
    }
}
