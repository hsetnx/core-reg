package com.lefinance.config.mq;

import com.lefinance.common.mq.push.DefaultPushConsumer;
import com.lefinance.common.mq.push.PushListenerAbstract;
import com.lefinance.regulation.mqlistener.Ptln102ConsumerListener;
import com.lefinance.regulation.mqlistener.Ptln103ConsumerListener;
import com.lefinance.regulation.mqlistener.Ptln104ConsumerListener;
import com.lefinance.regulation.mqlistener.Ptln105ConsumerListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: jingyan
 * @Time: 2017/6/30 14:58
 * @Describe: mqConsumer 实例化
 */
@Configuration
public class PushConsumerConfig {

    /*
    * MQ 服务器IP
    * */
    @Value("${namesrvAddr}")
    private String namesrvAddr;
    /*
    * 消费者组
    * */
    @Value("${consumer.group}")
    private String group;
    /*
    * 业务数据入库 TOPIC
    * */
    @Value("${business.data.topic}")
    private String businessDataTopic;
    /*
    * 消费者最大批处理数量
    * */
    @Value("${batch.max.size}")
    private int batchMaxSize;
    /*
    * 各个tag
    * */
    @Value("${ptln102.tag}")
    private String ptln102;
    @Value("${ptln103.tag}")
    private String ptln103;
    @Value("${ptln104.tag}")
    private String ptln104;
    @Value("${ptln105.tag}")
    private String ptln105;

    /**
     * @Author: jingyan
     * @Time: 2017/6/30 15:26
     * @Describe: ptln102Consumer
     */
    @Bean(name = "ptln102Consumer", initMethod = "init", destroyMethod = "destroy")
    public DefaultPushConsumer ptln102Consumer() {
        Ptln102ConsumerListener ptln102Listener = new Ptln102ConsumerListener();
        ptln102Listener.setTopic(businessDataTopic);
        ptln102Listener.setTag(ptln102);
        ptln102Listener.setMaxNums(batchMaxSize);
        return this.createPushConsumer(ptln102Listener);
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/30 15:26
     * @Describe: ptln103Consumer
     */
    @Bean(name = "ptln103Consumer", initMethod = "init", destroyMethod = "destroy")
    public DefaultPushConsumer ptln103Consumer() {
        Ptln103ConsumerListener ptln103Listener = new Ptln103ConsumerListener();
        ptln103Listener.setTopic(businessDataTopic);
        ptln103Listener.setTag(ptln103);
        ptln103Listener.setMaxNums(batchMaxSize);
        return this.createPushConsumer(ptln103Listener);
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/30 15:26
     * @Describe: ptln104Consumer
     */
    @Bean(name = "ptln104Consumer", initMethod = "init", destroyMethod = "destroy")
    public DefaultPushConsumer ptln104Consumer() {
        Ptln104ConsumerListener ptln104Listener = new Ptln104ConsumerListener();
        ptln104Listener.setTopic(businessDataTopic);
        ptln104Listener.setTag(ptln104);
        ptln104Listener.setMaxNums(batchMaxSize);
        return this.createPushConsumer(ptln104Listener);
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/30 15:26
     * @Describe: ptln105Consumer
     */
    @Bean(name = "ptln105Consumer", initMethod = "init", destroyMethod = "destroy")
    public DefaultPushConsumer ptln105Consumer() {
        Ptln105ConsumerListener ptln105Listener = new Ptln105ConsumerListener();
        ptln105Listener.setTopic(businessDataTopic);
        ptln105Listener.setTag(ptln105);
        ptln105Listener.setMaxNums(batchMaxSize);
        return this.createPushConsumer(ptln105Listener);
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/30 15:35
     * @Describe: 创建consumer
     */
    public DefaultPushConsumer createPushConsumer(PushListenerAbstract ptlnListener) {
        DefaultPushConsumer ptlnConsumer = new DefaultPushConsumer();
        ptlnConsumer.setNamesrvAddr(namesrvAddr);
        ptlnConsumer.setGroup(group + ptlnListener.getTag());
        ptlnConsumer.setPushListenerAbstract(ptlnListener);
        return ptlnConsumer;
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
