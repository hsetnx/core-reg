package com.lefinance.regulation.service;

import com.lefinance.common.constant.RegulatoryContants;
import com.lefinance.common.constant.TransEnum;
import com.lefinance.common.utils.CommonUtils;
import com.lefinance.common.utils.PubMethod;
import com.lefinance.regulation.dao.RegCqIssueInfoHypoledgeInfoMapper;
import com.lefinance.regulation.dao.RegCqIssueInfoMapper;
import com.lefinance.regulation.domain.RegCqIssueInfo;
import com.lefinance.regulation.domain.RegCqIssueInfoHypoledgeInfo;
import com.lefinance.regulation.model.ptln103.HypopledgeInfo;
import com.lefinance.regulation.model.ptln103.IssueInfo;
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
 * @Describe: 贷款发放上报
 */
@Service("ptln103Service")
public class PTLN103Service extends DataPushBaseService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private RegCqIssueInfoMapper regCqIssueInfoMapper;
    @Resource
    private AcctCreateKeyService acctCreateKeyService;
    @Resource
    private RegCqFileService regCqFileService;
    @Resource
    private RegCqFileLogService regCqFileLogService;
    @Resource
    private RegCqIssueInfoHypoledgeInfoMapper regCqIssueInfoHypoledgeInfoMapper;

    /**
     * @Author: jingyan
     * @Time: 2017/6/28 18:19
     * @Describe: 批量锁定数据
     */
    @Override
    public String lockData() {
        RegCqIssueInfo regCqIssueInfo = new RegCqIssueInfo();
        regCqIssueInfo.setStatus(RegulatoryContants.DataStatus.UNREPORT);
        regCqIssueInfo.setRetryNum(dataPushConfig.getRetryNum());
        regCqIssueInfo.setIsSuccess(false);
        List<RegCqIssueInfo> dataList = regCqIssueInfoMapper.selectBatchForUpload(regCqIssueInfo);
        if (PubMethod.isEmpty(dataList)) {
            logger.info("数据锁定---103未查询到数据...");
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
        RegCqIssueInfo record = new RegCqIssueInfo();
        record.setBatchGid(batchGid);
        record.setStatus(status);
        record.setUpdateTime(new Date());
        record.setUpdateUser("SYSTEM");
        if (RegulatoryContants.DataStatus.REPORTED == status) {
            record.setIsSuccess(true);
        }else {
            record.setIsSuccess(Boolean.FALSE);
        }
        regCqIssueInfoMapper.updateByBatchGid(record);
        return batchGid;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/28 18:20
     * @Describe: 创建上报文件
     */
    @Override
    public String crearteFile(String batchGid) {
        List<RegCqIssueInfo> dataList = regCqIssueInfoMapper.selectByBatchGid(batchGid);
        if (PubMethod.isEmpty(dataList)) {
            return null;
        }
        //生成文件
        String fileNo = acctCreateKeyService.createFileSequence(RegulatoryContants.FileSequence.REDIS_CACHE_FILE_103_SEQUENCE);
        if (PubMethod.isEmpty(fileNo)) {
            logger.info("生成上报文件---获取文件编号为空：PTLN103");
            return null;
        }
        String filename = this.createLocalFile(this.convert(dataList), TransEnum.PTLN103, batchGid, fileNo);
        logger.info("生成上报文件---filename={}", filename);
        //插入文件表
        this.regCqFileService.saveCqFileInfo(TransEnum.PTLN103, batchGid, filename, dataList.size());
        //插入日志表
        this.regCqFileLogService.insert(batchGid, Boolean.TRUE, RegulatoryContants.LogRemark.LOCK_DATA);
        return filename;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/27 17:40
     * @Describe: 更新表状态
     */
    public void updateRegCqIssueInfo(List<RegCqIssueInfo> dataList, Integer status, String batchGid) {
        for (RegCqIssueInfo regCqIssueInfo : dataList) {
            regCqIssueInfo.setStatus(status);
            regCqIssueInfo.setBatchGid(batchGid);
            regCqIssueInfo.setRetryNum(regCqIssueInfo.getRetryNum() + 1);
            this.regCqIssueInfoMapper.updateByPrimaryKeySelective(regCqIssueInfo);
        }
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/29 11:19
     * @Describe: 组装数据
     */
    private List<IssueInfo> convert(List<RegCqIssueInfo> dataList) {
        List<IssueInfo> list = new ArrayList<>();
        if (PubMethod.isEmpty(dataList)) {
            return list;
        }
        for (RegCqIssueInfo data : dataList) {
            IssueInfo info = new IssueInfo();
            BeanUtils.copyProperties(data, info);
            List<RegCqIssueInfoHypoledgeInfo> regCqIssueInfoHypopledgeInfoList = regCqIssueInfoHypoledgeInfoMapper.selectByIssueInfoGid(data.getGid());
            if (!PubMethod.isEmpty(regCqIssueInfoHypopledgeInfoList)) {
                List<HypopledgeInfo> hypopledgeInfoList = new ArrayList<>();
                for (RegCqIssueInfoHypoledgeInfo item : regCqIssueInfoHypopledgeInfoList) {
                    HypopledgeInfo hypopledgeInfo = new HypopledgeInfo();
                    BeanUtils.copyProperties(item, hypopledgeInfo);
                    hypopledgeInfoList.add(hypopledgeInfo);
                }
                info.setHypopledgeInfoList(hypopledgeInfoList);
            }
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
    public int saveBusinessDate(RegCqIssueInfo record) {
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        record.setCreateUser("SYSTEM");
        record.setUpdateUser("SYSTEM");
        record.setIsSuccess(false);
        record.setRetryNum(0);
        record.setStatus(RegulatoryContants.DataStatus.UNREPORT);
        record.setReportTime(new Date());
        record.setOrgCode(dataPushConfig.getLocalBranchId());
        logger.info("103业务数据入库：" + record.toString());
        return regCqIssueInfoMapper.insert(record);
    }
}
