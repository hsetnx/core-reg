package com.lefinance.common.redislock;

import com.lefinance.common.utils.JedisClient;

/**
 * @Author: jingyan
 * @Time: 2017/7/24 19:00
 * @Describe: 分布式锁
 */
public class JedisLock {

    //锁的key
    private String lockKey;
    //锁等待，防止线程饥饿  (等待获取锁的最长时间)
    private int waitingTime = 0;
    //锁超时，防止线程在入锁以后，无限的执行等待  (持有锁的最长时间)
    private int holdingTime = 0;
    //获取锁状态
    boolean locked = false;

    /**
     * @Author: jingyan
     * @Time: 2017/7/24 19:05
     * @Describe: 构造方法
     */
    public JedisLock(String lockKey, int waitingTime, int holdingTime) {
        this.lockKey = lockKey;
        this.waitingTime = waitingTime;
        this.holdingTime = holdingTime;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/7/24 18:42
     * @Describe: 获取锁
     */
    public boolean acquire() throws InterruptedException {
        int timeout = waitingTime;
        while (timeout >= 0) {
            long expires = System.currentTimeMillis() + holdingTime + 1;
            //锁到期时间
            String expiresStr = String.valueOf(expires);
            //拿到锁
            if (JedisClient.setnx(lockKey, expiresStr) == 1) {
                // lock acquired
                locked = true;
                return true;
            }
            //没拿到,则看看里面现在具体是什么
            String oldExpiresStr = JedisClient.get(lockKey);
            //如果不为空 && 超时未释放
            if (oldExpiresStr != null && Long.parseLong(oldExpiresStr) < System.currentTimeMillis()) {
                //获取上一个锁到期时间，并设置现在的锁到期时间
                //只有一个线程才能获取上一个线上的设置时间，因为jedis.getSet是同步的
                String oldValueStr = JedisClient.getSet(lockKey, expiresStr);
                //校验
                //如过这个时候，多个线程恰好都到了这里，但是只有一个线程的设置值和当前值相同，他才有权利获取锁
                if (oldValueStr != null && oldValueStr.equals(oldExpiresStr)) {
                    // lock acquired
                    locked = true;
                    return true;
                }
            }
            //继续休息100毫秒，等待
            timeout -= 100;
            Thread.sleep(100);
        }
        return false;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/7/24 18:49
     * @Describe: 释放锁
     */
    public void release() {
        if (locked) {
            JedisClient.remove(lockKey);
            locked = false;
        }
    }
}
