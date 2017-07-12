package com.lefinance.config.mq;

import com.lefinance.common.mq.push.DefaultPushConsumer;
import com.lefinance.regulation.mqlistener.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: jingyan
 * @Time: 2017/6/30 14:58
 * @Describe: mqConsumer 实例化
 */
@Component
public class PushConsumerConfig {

    @Value("${namesrvAddr}")
    private String namesrvAddr;
    @Value("${consumer.group}")
    private String group;
    @Value("${batch.max.size}")
    private int batchMaxSize;
    @Value("${business.data.topic}")
    private String businessDataTopic;
    @Value("${ptln102.tag}")
    private String ptln102;
    @Value("${ptln103.tag}")
    private String ptln103;
    @Value("${ptln104.tag}")
    private String ptln104;
    @Value("${ptln105.tag}")
    private String ptln105;
    @Value("${ptln107.tag}")
    private String ptln107;

    @Resource
    private Ptln102ConsumerListener ptln102ConsumerListener;
    @Resource
    private Ptln103ConsumerListener ptln103ConsumerListener;
    @Resource
    private Ptln104ConsumerListener ptln104ConsumerListener;
    @Resource
    private Ptln105ConsumerListener ptln105ConsumerListener;
    @Resource
    private Ptln107ConsumerListener ptln107ConsumerListener;


    /**
     * @Author: jingyan
     * @Time: 2017/6/30 15:26
     * @Describe: ptln102Consumer
     */
    @Bean(name = "ptln102Consumer", initMethod = "init", destroyMethod = "destroy")
    public DefaultPushConsumer ptln102Consumer() {
        DefaultPushConsumer ptln102Consumer = new DefaultPushConsumer(namesrvAddr, group, businessDataTopic,
                ptln102, batchMaxSize);
        ptln102Consumer.setPushListenerAbstract(ptln102ConsumerListener);
        return ptln102Consumer;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/30 15:26
     * @Describe: ptln103Consumer
     */
    @Bean(name = "ptln103Consumer", initMethod = "init", destroyMethod = "destroy")
    public DefaultPushConsumer ptln103Consumer() {
        DefaultPushConsumer ptln103Consumer = new DefaultPushConsumer(namesrvAddr, group, businessDataTopic,
                ptln103, batchMaxSize);
        ptln103Consumer.setPushListenerAbstract(ptln103ConsumerListener);
        return ptln103Consumer;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/30 15:26
     * @Describe: ptln104Consumer
     */
    @Bean(name = "ptln104Consumer", initMethod = "init", destroyMethod = "destroy")
    public DefaultPushConsumer ptln104Consumer() {
        DefaultPushConsumer ptln104Consumer = new DefaultPushConsumer(namesrvAddr, group, businessDataTopic,
                ptln104, batchMaxSize);
        ptln104Consumer.setPushListenerAbstract(ptln104ConsumerListener);
        return ptln104Consumer;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/30 15:26
     * @Describe: ptln105Consumer
     */
    @Bean(name = "ptln105Consumer", initMethod = "init", destroyMethod = "destroy")
    public DefaultPushConsumer ptln105Consumer() {
        DefaultPushConsumer ptln105Consumer = new DefaultPushConsumer(namesrvAddr, group, businessDataTopic,
                ptln105, batchMaxSize);
        ptln105Consumer.setPushListenerAbstract(ptln105ConsumerListener);
        return ptln105Consumer;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/30 15:26
     * @Describe: ptln105Consumer
     */
    @Bean(name = "ptln107Consumer", initMethod = "init", destroyMethod = "destroy")
    public DefaultPushConsumer ptln107Consumer() {
        DefaultPushConsumer ptln107Consumer = new DefaultPushConsumer(namesrvAddr, group, businessDataTopic,
                ptln107, batchMaxSize);
        ptln107Consumer.setPushListenerAbstract(ptln107ConsumerListener);
        return ptln107Consumer;
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

    public String getBusinessDataTopic() {
        return businessDataTopic;
    }

    public void setBusinessDataTopic(String businessDataTopic) {
        this.businessDataTopic = businessDataTopic;
    }

    public int getBatchMaxSize() {
        return batchMaxSize;
    }

    public void setBatchMaxSize(int batchMaxSize) {
        this.batchMaxSize = batchMaxSize;
    }

    public String getPtln102() {
        return ptln102;
    }

    public void setPtln102(String ptln102) {
        this.ptln102 = ptln102;
    }

    public String getPtln103() {
        return ptln103;
    }

    public void setPtln103(String ptln103) {
        this.ptln103 = ptln103;
    }

    public String getPtln104() {
        return ptln104;
    }

    public void setPtln104(String ptln104) {
        this.ptln104 = ptln104;
    }

    public String getPtln105() {
        return ptln105;
    }

    public void setPtln105(String ptln105) {
        this.ptln105 = ptln105;
    }
}
