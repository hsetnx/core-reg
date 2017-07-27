package com.lefinance.config.redis;

import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: jingyan
 * @Time: 2017/7/27 15:43
 * @Describe: redis 工具方法
 */
@Component("redisTools")
public class RedisTools {

    @Resource
    private JedisCluster jedisCluster;

    private void assertPoolNotNull() {
        if (jedisCluster == null) {
            throw new NullPointerException("shardedJedisPool is null");
        }
    }

    public void put(String key, String value) {
        this.assertPoolNotNull();
        jedisCluster.set(key, value);
    }

    public void putWithExpire(String key, String value, int seconds) {
        this.assertPoolNotNull();
        jedisCluster.set(key, value);
        jedisCluster.expire(key, seconds);
    }

    public void incr(String key) {
        this.assertPoolNotNull();
        jedisCluster.incr(key);
    }

    public void decr(String key) {
        this.assertPoolNotNull();
        jedisCluster.decr(key);
    }

    public boolean sismember(String key, String member) {
        this.assertPoolNotNull();
        return jedisCluster.sismember(key, member);
    }

    public void sadd(String key, String... member) {
        this.assertPoolNotNull();
        jedisCluster.sadd(key, member);
    }

    public Set<String> smembers(String key, String... member) {
        this.assertPoolNotNull();
        return jedisCluster.smembers(key);
    }

    public Long ttl(String key) {
        this.assertPoolNotNull();
        return jedisCluster.ttl(key);
    }

    public void batchPut(Map<String, String> map) {
        this.assertPoolNotNull();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            jedisCluster.set(entry.getKey(), entry.getValue());
        }
    }

    public String get(String key) {
        this.assertPoolNotNull();
        return jedisCluster.get(key);
    }

    public boolean exists(String key) {
        this.assertPoolNotNull();
        return jedisCluster.exists(key);
    }

    public void remove(String key) {
        this.assertPoolNotNull();
        jedisCluster.del(key);
    }

    public Set<String> hkeys(String hmName) {
        try {
            return jedisCluster.hkeys(hmName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean hmset(String hmKeyname, Map<String, String> map) {
        this.assertPoolNotNull();
        try {
            jedisCluster.hmset(hmKeyname, map);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean hset(String hmName, String keyName, String value) {
        this.assertPoolNotNull();
        try {
            jedisCluster.hset(hmName, keyName, value);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<String> hvals(String hmName) {
        this.assertPoolNotNull();
        return jedisCluster.hvals(hmName);
    }

    public Map<String, String> hgetAll(String hmName) {
        this.assertPoolNotNull();
        return jedisCluster.hgetAll(hmName);
    }

    public String hmget(String hmKeyname, String keyname) {
        this.assertPoolNotNull();
        return jedisCluster.hget(hmKeyname, keyname);
    }

    public int setnx(String key, String value) {
        this.assertPoolNotNull();
        return jedisCluster.setnx(key, value).intValue();
    }

    public void lpush(String key, String value, int seconds) {
        this.assertPoolNotNull();
        jedisCluster.lpush(key, value);
        jedisCluster.expire(key, seconds);
    }

    public void lpush(String key, String value) {
        this.assertPoolNotNull();
        jedisCluster.lpush(key, value);
    }

    public List<String> lrange(String key, long start, long end) {
        this.assertPoolNotNull();
        return jedisCluster.lrange(key, start, end);
    }

    public Set<String> srange(String key) {
        this.assertPoolNotNull();
        Set<String> codeSet = jedisCluster.smembers(key);
        return codeSet;
    }

    public List<String> brpop(String key) {
        this.assertPoolNotNull();
        return jedisCluster.brpop(0, key);
    }

    public String lpop(String key) {
        this.assertPoolNotNull();
        return jedisCluster.lpop(key);
    }

    public Long incrBy(String key, long integer) {
        this.assertPoolNotNull();
        return jedisCluster.incrBy(key, integer);
    }

    public String getSet(String key, String value) {
        this.assertPoolNotNull();
        return jedisCluster.getSet(key, value);
    }
}
