package com.lefinance.common.redislock;


import com.lefinance.common.utils.JedisClient;
import com.lefinance.common.utils.PubMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: jingyan
 * @Time: 2017/3/17 11:38
 * @Describe:创建主键的工具类
 */
public class CreatePrimaryKey {

    private static Logger logger = LoggerFactory.getLogger(CreatePrimaryKey.class);
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

    /**
     * @Author: jingyan
     * @Time: 2017/7/24 19:06
     * @Describe: 获取主键
     */
    public Object getPrimaryKey() {
        logger.info("redis生成序列号，获取锁key={}", keyPrefix);
        DistributedLock distributedLock = new DistributedLock(keyPrefix);
        Object object = null;
        long begin = System.currentTimeMillis();
        try {
            boolean flag = false;
            synchronized (this) {
                flag = distributedLock.getLock();
            }
            if (flag) { // 启用锁
                logger.info("获取主键,key={}的锁获取成功,开始执行生成序列号方法...", keyPrefix);
                object = this.run();
            } else {
                logger.error("获取主键,key={}的锁获取失败...", keyPrefix);
            }
        } catch (Exception e) {
            logger.error("获取主键异常：" + e.getMessage());
            e.printStackTrace();
        } finally {
            logger.debug("获取主键,锁的key={} 开始释放锁", keyPrefix);
            distributedLock.releaseLock();
        }
        long costTime = System.currentTimeMillis() - begin;
        logger.info("获取主键,锁的key={} 耗时costTime={}", keyPrefix, costTime);
        return object;
    }


    /**
     * @Author: jingyan
     * @Time: 2017/6/28 18:31
     * @Describe: 获取序列号
     */
    public Object run() {
        //获取业务时间
        long begin = System.currentTimeMillis();
        String serialNoKey = keyPrefix + keySuffix;
        String serialNo = JedisClient.get(serialNoKey);
        if (PubMethod.isEmpty(serialNo)) {
            JedisClient.putWithExpire(serialNoKey, "1", keepTime);
            serialNo = "1";
        }
        String strNum = PubMethod.int2Str(Integer.parseInt(serialNo), maxLenth);
        JedisClient.incr(serialNoKey);
        long costTime = System.currentTimeMillis() - begin;
        logger.debug("获取序列号，耗时costTime={}", costTime);
        return keySuffix + strNum;
    }
}
