package com.lefinance.config.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.util.StringUtils;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: jingyan
 * @Time: 2017/7/27 15:25
 * @Describe:
 */
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfig {

    private static Logger logger = LoggerFactory.getLogger(RedisConfig.class);
    @Resource
    private RedisProperties redisProperties;

    /**
     * @Author: jingyan
     * @Time: 2017/7/27 16:06
     * @Describe: 初始化redis连接
     */
    @Bean(name = "jedisCluster")
    @Primary
    public JedisCluster jedisCluster() {
        logger.info("jedisCluster init , redisProperties={}", redisProperties.toString());
        String redisStr = redisProperties.getServers();
        if (!StringUtils.isEmpty(redisStr)) {
            String[] redisArr = redisStr.split(",");
            Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
            for (String re : redisArr) {
                String[] url = re.split(":");
                int port = Integer.parseInt(url[1]);
                jedisClusterNodes.add(new HostAndPort(url[0], port));
            }
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(redisProperties.getMaxTotal());
            jedisPoolConfig.setMaxIdle(redisProperties.getMaxIdle());
            jedisPoolConfig.setMaxWaitMillis(redisProperties.getMaxWaitTime());
            JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes,
                    redisProperties.getConnectionTimeout(),
                    redisProperties.getSoTimeout(),
                    redisProperties.getMaxAttempts(),
                    redisProperties.getPassword(),
                    jedisPoolConfig);
            logger.info("jedisCluster initialization success...");
            return jedisCluster;
        } else {
            logger.error("jedisCluster 初始化,redisStr为空：" + redisStr);
        }
        return null;
    }

}
