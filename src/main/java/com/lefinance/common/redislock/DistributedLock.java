package com.lefinance.common.redislock;


/**
 * @Author: jingyan
 * @Time: 2017/3/17 11:36
 * @Describe:分布式锁工具类
 */
public class DistributedLock {

    private String lockKey;              //锁key
    private int waitingTime = 3000;      //等待时间
    private int holdingTime = 10000;     //持有时间
    private JedisLock jedisLock;         //redis 锁工具

    /**
     * @Author: jingyan
     * @Time: 2017/7/24 19:00
     * @Describe: 构造方法
     */
    public DistributedLock(String lockKey) {
        this.lockKey = lockKey;
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
     * @Describe:释放锁 (优化)
     */
    public void releaseLock() {
        if (jedisLock != null) {
            try {
                synchronized (jedisLock) {
                    jedisLock.release();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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

    public JedisLock getJedisLock() {
        return jedisLock;
    }

    public void setJedisLock(JedisLock jedisLock) {
        this.jedisLock = jedisLock;
    }
}
