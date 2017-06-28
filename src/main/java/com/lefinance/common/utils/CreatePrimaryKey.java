package com.lefinance.common.utils;

import com.leFinance.creditLoan.redisDistributedLock.LockCommonAbstract;

import java.util.Map;

/**
 * @Author: jingyan
 * @Time: 2017/3/17 11:38
 * @Describe:创建主键的工具类
 */
public class CreatePrimaryKey extends LockCommonAbstract {

    //redis序列号key前缀
    private String keyPrefix;
    //redis序列号key后缀
    private String keySuffix;
    //序列号在redis的有效保存时间
    private int keepTime;
    //转换成字符串的序列号长度(数字前面补0)
    private int maxLenth;

    public CreatePrimaryKey(String keyPrefix, String keySuffix, int keepTime, int maxLenth) {
        this.keyPrefix = keyPrefix;
        this.keySuffix = keySuffix;
        this.keepTime = keepTime;
        this.maxLenth = maxLenth;
    }

    @Override
    public Object run(String s, Map<String, Object> map) {
        //获取业务时间
        String serialNoKey = keyPrefix + keySuffix;
        String serialNo = JedisClient.get(serialNoKey);
        if (PubMethod.isEmpty(serialNo)) {
            JedisClient.putWithExpire(serialNoKey, "1", keepTime);
            serialNo = "1";
        }
        String strNum = PubMethod.int2Str(Integer.parseInt(serialNo), maxLenth);
        JedisClient.incr(serialNoKey);
        return keySuffix + strNum;
    }
}
