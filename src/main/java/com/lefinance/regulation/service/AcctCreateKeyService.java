package com.lefinance.regulation.service;

import com.leFinance.creditLoan.redisDistributedLock.DispersedLock;
import com.leFinance.creditLoan.redisDistributedLock.RegisterUtil;
import com.lefinance.common.utils.CreatePrimaryKey;
import com.lefinance.common.utils.PubMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author: jingyan
 * @Time: 2017/3/17 11:28
 * @Describe:
 */
@Service
public class AcctCreateKeyService {

    private static Logger logger = LoggerFactory.getLogger(AcctCreateKeyService.class);
    //流水号key值时间后缀格式化标准
    public static final String DATE_FROMAT = "yyyyMM";
    public static final String DATE_FROMAT_DD = "yyyyMMdd";
    //redis 自增流水号保存时间 暂定7天
    public static final int HOLD_TIME_WEEK = 604800;   //7天
    public static final int HOLD_TIME_MONTH = 3456000; //40天


    public static final String REDIS_CACHE_FILE_SEQUENCE = "REDIS_CACHE_FILE_SEQUENCE";


    /**
     * @Author: jingyan
     * @Time: 2017/4/12 18:02
     * @Describe: 获取合同文件序列号
     */
    public String createContractSeq() {
        try {
            DispersedLock dispersedLock = RegisterUtil.getDispersedLock(REDIS_CACHE_FILE_SEQUENCE);
            Object object = dispersedLock.wrap(new CreatePrimaryKey(REDIS_CACHE_FILE_SEQUENCE, PubMethod.getDateStr(DATE_FROMAT_DD), HOLD_TIME_WEEK, 2), null, null);
            if (PubMethod.isEmpty(object)) {
                logger.info("获取REDIS_CACHE_FILE_SEQUENCE序列号失败...");
                throw new RuntimeException("获取REDIS_CACHE_FILE_SEQUENCE序列号失败");
            }
            String seqNo=object.toString();
            String contractNo=seqNo.substring(seqNo.length()-2);
            return contractNo;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

}
