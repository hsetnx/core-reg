package com.lefinance.common.utils;


import com.leFinance.creditLoan.redisDistributedLock.JedisLock;

/**
 * @Author: jingyan
 * @Time: 2017/3/17 11:36
 * @Describe:分布式锁工具类
 */
public class DistributedLock {

    private JedisLock jedisLock;
    private String lockKey;      //锁key
    private int waitingTime;     //等待时间
    private int holdingTime;     //持有时间

    public DistributedLock(String lockKey) {
        this(lockKey, 3000, 10000);
    }

    /**
     * @Author: jingyan
     * @Time: 2017/3/17 11:35
     * @Describe:构造方法
     */
    public DistributedLock(String lockKey, int waitingTime, int holdingTime) {
        this.lockKey = lockKey;
        this.waitingTime = waitingTime;
        this.holdingTime = holdingTime;
        this.jedisLock = new JedisLock(lockKey.intern(), waitingTime, holdingTime);
    }

    /**
     * @Author: jingyan
     * @Time: 2017/3/17 11:35
     * @Describe:获取锁
     */
    public boolean getLock() {
        try {
            boolean flag = false;
            synchronized (this) {
                flag = jedisLock.acquire();
            }
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/3/17 11:35
     * @Describe:释放锁
     */
    public void releaseLock(JedisLock lock) {
        if (lock != null) {
            try {
                synchronized (lock) {
                    lock.release();
                }
            } catch (Exception e) {
            }
        }
    }

    public JedisLock getJedisLock() {
        return jedisLock;
    }

    public void setJedisLock(JedisLock jedisLock) {
        this.jedisLock = jedisLock;
    }

    public String getLockKey() {
        return lockKey;
    }

    public void setLockKey(String lockKey) {
        this.lockKey = lockKey;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getHoldingTime() {
        return holdingTime;
    }

    public void setHoldingTime(int holdingTime) {
        this.holdingTime = holdingTime;
    }
}
