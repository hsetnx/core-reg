package com.lefinance.common.mq.push;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: jingyan
 * @Time: 2017/4/26 16:37
 * @Describe:
 */
public class DefaultPushConsumer {

    private final Logger logger = LoggerFactory.getLogger(DefaultPushConsumer.class);
    //MQ服务器地址
    private String namesrvAddr;
    //集群组名
    private String group;
    //最大批量消息处理数目
    private int maxNums;
    //订阅主题
    private String topic;
    //订阅标签
    private String tag;
    //监听对象
    private PushListenerAbstract pushListenerAbstract;
    //push 消费者
    private DefaultMQPushConsumer defaultMQPushConsumer;

    /**
     * @Author: jingyan
     * @Time: 2017/7/4 20:25
     * @Describe: DefaultPushConsumer
     */
    public DefaultPushConsumer(String namesrvAddr, String group, String topic, String tag, int maxNums) {
        this.namesrvAddr = namesrvAddr;
        this.group = group;
        this.topic = topic;
        this.tag = tag;
        this.maxNums = maxNums;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/4/26 16:58
     * @Describe: 初始化方法
     */
    public void init() throws InterruptedException, MQClientException {
        logger.info("--------- DefaultPushConsumer initialize begin! ---------");
        logger.info("--------- 集群信息：namesrvAddr={},  group={} ---------", namesrvAddr, group);
        logger.info("--------- 主题信息：" + pushListenerAbstract.toString() + " ---------");
        defaultMQPushConsumer = new DefaultMQPushConsumer();
        //服务器地址
        defaultMQPushConsumer.setNamesrvAddr(namesrvAddr);
        //消费者组
        defaultMQPushConsumer.setConsumerGroup(group + "_" + topic + "_" + tag);
        //订阅信息
        defaultMQPushConsumer.subscribe(topic, tag);
        //消费起始位置（队列前后）
        defaultMQPushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        //最大批量消息处理数目
        defaultMQPushConsumer.setConsumeMessageBatchMaxSize(maxNums);
        //设置为集群消费(区别于广播消费)
        defaultMQPushConsumer.setMessageModel(MessageModel.CLUSTERING);
        //具体消费监听代理类
        defaultMQPushConsumer.registerMessageListener(pushListenerAbstract);
        //启动
        defaultMQPushConsumer.start();
        logger.info("--------- DefaultPushConsumer initialize success! ---------");
    }

    /**
     * @Author: jingyan
     * @Time: 2017/7/5 10:06
     * @Describe: destroy
     */
    public void destroy() {
        logger.info("--------- DefaultPushConsumer shutdown start! ---------");
        defaultMQPushConsumer.shutdown();
        logger.info("--------- DefaultPushConsumer shutdown success! ---------");
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

    public DefaultMQPushConsumer getDefaultMQPushConsumer() {
        return defaultMQPushConsumer;
    }

    public void setDefaultMQPushConsumer(DefaultMQPushConsumer defaultMQPushConsumer) {
        this.defaultMQPushConsumer = defaultMQPushConsumer;
    }

    public PushListenerAbstract getPushListenerAbstract() {
        return pushListenerAbstract;
    }

    public void setPushListenerAbstract(PushListenerAbstract pushListenerAbstract) {
        this.pushListenerAbstract = pushListenerAbstract;
    }

    public int getMaxNums() {
        return maxNums;
    }

    public void setMaxNums(int maxNums) {
        this.maxNums = maxNums;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
