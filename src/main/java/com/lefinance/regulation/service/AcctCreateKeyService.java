package com.lefinance.regulation.service;


import com.lefinance.common.redislock.CreatePrimaryKey;
import com.lefinance.common.utils.PubMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author: jingyan
 * @Time: 2017/3/17 11:28
 * @Describe: 创建序列号
 */
@Service
public class AcctCreateKeyService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //流水号key值时间后缀格式化标准
    public static final String DATE_FROMAT = "yyyyMM";
    public static final String DATE_FROMAT_DD = "yyyyMMdd";
    //redis 自增流水号保存时间 暂定7天
    public static final int HOLD_TIME_WEEK = 604800;   //7天
    public static final int HOLD_TIME_MONTH = 3456000; //40天

    /**
     * @Author: jingyan
     * @Time: 2017/4/12 18:02
     * @Describe: 获取上报文件序列号
     */
    public String createFileSequence(String fileSequenceKey) {
        try {
            CreatePrimaryKey createPrimaryKey=new CreatePrimaryKey(fileSequenceKey, PubMethod.getDateStr(DATE_FROMAT_DD), HOLD_TIME_WEEK, 2);
            Object object = createPrimaryKey.getPrimaryKey();
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
