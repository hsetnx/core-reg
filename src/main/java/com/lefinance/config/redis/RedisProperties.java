package com.lefinance.config.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: jingyan
 * @Time: 2017/7/27 15:26
 * @Describe: redis 配置信息
 */
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {

    private String servers;
    private String password;
    private int maxTotal = 100;
    private int maxIdle = 50;
    private long maxWaitTime = 1000;
    private int connectionTimeout = 5000;
    private int soTimeout = 5000;
    private int maxAttempts = 1;

    @Override
    public String toString() {
        return "RedisProperties{" +
                "servers='" + servers + '\'' +
                ", password='" + password + '\'' +
                ", maxTotal=" + maxTotal +
                ", maxIdle=" + maxIdle +
                ", maxWaitTime=" + maxWaitTime +
                ", connectionTimeout=" + connectionTimeout +
                ", soTimeout=" + soTimeout +
                ", maxAttempts=" + maxAttempts +
                '}';
    }

    public String getServers() {
        return servers;
    }

    public void setServers(String servers) {
        this.servers = servers;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public long getMaxWaitTime() {
        return maxWaitTime;
    }

    public void setMaxWaitTime(long maxWaitTime) {
        this.maxWaitTime = maxWaitTime;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getSoTimeout() {
        return soTimeout;
    }

    public void setSoTimeout(int soTimeout) {
        this.soTimeout = soTimeout;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public void setMaxAttempts(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }
}
