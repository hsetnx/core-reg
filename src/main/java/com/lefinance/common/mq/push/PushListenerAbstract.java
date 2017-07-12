package com.lefinance.common.mq.push;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Author: jingyan
 * @Time: 2017/4/27 20:40
 * @Describe:
 */
public abstract class PushListenerAbstract implements MessageListenerConcurrently {

    private final Logger logger = LoggerFactory.getLogger(PushListenerAbstract.class);

    /**
     * @Author: jingyan
     * @Time: 2017/4/27 20:44
     * @Describe: 业务实现逻辑
     */
    public abstract ConsumeConcurrentlyStatus handleMsg(List<MessageExt> messageExts, ConsumeConcurrentlyContext context);

    /**
     * @Author: jingyan
     * @Time: 2017/4/27 20:45
     * @Describe:推送入口
     */
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        logger.info("------ push consume message ------");
        return this.handleMsg(msgs, context);
    }

}
