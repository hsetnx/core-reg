package com.lefinance.regulation.mq.config;

import com.lefinance.common.mq.producer.DefaultProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: jingyan
 * @Time: 2017/6/30 15:56
 * @Describe:
 */
@Configuration
public class DefaultProducerConfig {

    @Value("${namesrvAddr}")
    private String namesrvAddr;
    @Value("${producer.group}")
    private String group;

    /**
     * @Author: jingyan
     * @Time: 2017/6/30 16:01
     * @Describe: 创建默认的生产者, 单例,连接多个mq，可创建多个
     * 用法 :   @Resource DefaultProducer defaultProducer
     */
    @Bean(name = "defaultProducer", initMethod = "init", destroyMethod = "destroy")
    public DefaultProducer getDefaultProducer() {
        DefaultProducer defaultProducer = new DefaultProducer();
        defaultProducer.setNamesrvAddr(namesrvAddr);
        defaultProducer.setGroup(group);
        return defaultProducer;
    }

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
