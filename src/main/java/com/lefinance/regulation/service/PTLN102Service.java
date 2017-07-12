package com.lefinance.regulation.service;

import com.lefinance.common.constant.RegulatoryContants;
import com.lefinance.common.constant.TransEnum;
import com.lefinance.common.utils.CommonUtils;
import com.lefinance.common.utils.PubMethod;
import com.lefinance.regulation.dao.RegCqContractInfoCoCustomerInfoMapper;
import com.lefinance.regulation.dao.RegCqContractInfoMapper;
import com.lefinance.regulation.domain.RegCqContractInfo;
import com.lefinance.regulation.domain.RegCqContractInfoCoCustomerInfo;
import com.lefinance.regulation.model.ptln102.CoCustomerInfo;
import com.lefinance.regulation.model.ptln102.ContractInfo;
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
 * @Time: 2017/6/27 14:49
 * @Describe: 贷款合同上报
 */
@Service("ptln102Service")
public class PTLN102Service extends DataPushBaseService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private RegCqContractInfoMapper regCqContractInfoMapper;
    @Resource
    private RegCqContractInfoCoCustomerInfoMapper regCqContractInfoCoCustomerInfoMapper;
    @Resource
    private AcctCreateKeyService acctCreateKeyService;
    @Resource
    private RegCqFileService regCqFileService;
    @Resource
    private RegCqFileLogService regCqFileLogService;


    /**
     * @Author: jingyan
     * @Time: 2017/6/28 14:48
     * @Describe: 实现父类---锁定数据
     */
    @Override
    public String lockData() {
        RegCqContractInfo regCqContractInfo = new RegCqContractInfo();
        regCqContractInfo.setStatus(RegulatoryContants.DataStatus.UNREPORT);
        regCqContractInfo.setRetryNum(dataPushConfig.getRetryNum());
        regCqContractInfo.setIsSuccess(false);
        List<RegCqContractInfo> dataList = regCqContractInfoMapper.selectBatchForUpload(regCqContractInfo);
        if (PubMethod.isEmpty(dataList)) {
            logger.info("数据锁定---102未查询到数据...");
            return null;
        }
        String batchGid = CommonUtils.getUUIDWithoutSeparator();
        //更新合同表数据状态,锁住这批数据
        this.updateRegCqContractInfo(dataList, RegulatoryContants.DataStatus.REPORTING, batchGid);
        return batchGid;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/28 14:44
     * @Describe: 实现父类---解锁数据
     */
    @Override
    public String unlockData(String batchGid, int status) {
        RegCqContractInfo record = new RegCqContractInfo();
        record.setBatchGid(batchGid);
        record.setStatus(status);
        record.setUpdateTime(new Date());
        record.setUpdateUser("SYSTEM");
        if (RegulatoryContants.DataStatus.REPORTED == status) {
            record.setIsSuccess(Boolean.TRUE);
        }else {
            record.setIsSuccess(Boolean.FALSE);
        }
        this.regCqContractInfoMapper.updateByBatchGid(record);
        return batchGid;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/27 17:57
     * @Describe: 创建上报文件
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public String crearteFile(String batchGid) {
        //查询批次数据详情
        List<RegCqContractInfo> dataList = regCqContractInfoMapper.selectByBatchGid(batchGid);
        if (PubMethod.isEmpty(dataList)) {
            return null;
        }
        //生成文件
        String fileNo = acctCreateKeyService.createFileSequence(RegulatoryContants.FileSequence.REDIS_CACHE_FILE_102_SEQUENCE);
        if (PubMethod.isEmpty(fileNo)) {
            logger.info("生成上报文件---获取文件编号为空：PTLN102");
            return null;
        }
        String filename = this.createLocalFile(this.convert(dataList), TransEnum.PTLN102, batchGid, fileNo);
        logger.info("生成上报文件---filename={}", filename);
        //插入文件表
        this.regCqFileService.saveCqFileInfo(TransEnum.PTLN102, batchGid, filename, dataList.size());
        //插入日志表
        this.regCqFileLogService.insert(batchGid, Boolean.TRUE, RegulatoryContants.LogRemark.LOCK_DATA);
        return filename;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/27 15:48
     * @Describe: 组装数据
     */
    private List<ContractInfo> convert(List<RegCqContractInfo> dataList) {
        List<ContractInfo> list = new ArrayList<>();
        for (RegCqContractInfo regCqContractInfo : dataList) {
            ContractInfo contractInfo = new ContractInfo();
            BeanUtils.copyProperties(regCqContractInfo, contractInfo);
            List<RegCqContractInfoCoCustomerInfo> customerInfoList = regCqContractInfoCoCustomerInfoMapper.selectByContractInfoGid(regCqContractInfo.getGid());
            List<CoCustomerInfo> coCustomerInfoList = new ArrayList<>();
            for (RegCqContractInfoCoCustomerInfo customerInfo : customerInfoList) {
                CoCustomerInfo coCustomerInfo = new CoCustomerInfo();
                BeanUtils.copyProperties(customerInfo, coCustomerInfo);
                coCustomerInfoList.add(coCustomerInfo);
            }
            contractInfo.setCoCustomerInfoList(coCustomerInfoList);
            list.add(contractInfo);
        }
        return list;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/27 17:40
     * @Describe: 更新合同表状态
     */
    public void updateRegCqContractInfo(List<RegCqContractInfo> dataList, Integer status, String batchGid) {
        for (RegCqContractInfo contractInfo : dataList) {
            contractInfo.setStatus(status);
            contractInfo.setBatchGid(batchGid);
            contractInfo.setRetryNum(contractInfo.getRetryNum() + 1);
            contractInfo.setReportTime(new Date());
            this.regCqContractInfoMapper.updateByPrimaryKeySelective(contractInfo);
        }
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/30 18:30
     * @Describe: 业务数据入库
     */
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class}, propagation = Propagation.REQUIRES_NEW)
    public int saveBusinessDate(RegCqContractInfo record) {
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        record.setCreateUser("SYSTEM");
        record.setUpdateUser("SYSTEM");
        record.setIsSuccess(false);
        record.setRetryNum(0);
        record.setStatus(RegulatoryContants.DataStatus.UNREPORT);
        record.setReportTime(new Date());
        record.setOrgCode(dataPushConfig.getLocalBranchId());
        logger.info("102业务数据入库：" + record.toString());
        return regCqContractInfoMapper.insert(record);
    }
}
