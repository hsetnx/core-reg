package com.lefinance.regulation.mqlistener;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.lefinance.common.mq.push.PushListenerAbstract;
import com.lefinance.regulation.domain.RegCqNetbookInfo;
import com.lefinance.regulation.service.PTLN107Service;
import com.lefinance.regulation.service.RegBusinessDataRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: jingyan
 * @Time: 2017/7/4 15:35
 * @Describe:
 */
@Component
public class Ptln107ConsumerListener extends PushListenerAbstract {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private PTLN107Service ptln107Service;
    @Resource
    private RegBusinessDataRecordService regBusinessDataRecordService;

    /**
     * @Author: jingyan
     * @Time: 2017/7/4 15:38
     * @Describe: 网签上报数据入库
     */
    @Override
    public ConsumeConcurrentlyStatus handleMsg(List<MessageExt> messageExts, ConsumeConcurrentlyContext context) {
        try {
            for (MessageExt messageExt : messageExts) {
                String jsonStr = new String(messageExt.getBody());
                logger.info("107消息消费,msgBody={}", jsonStr);
                boolean flag = regBusinessDataRecordService.checkMsgRecord(messageExt.getMsgId(), jsonStr);
                if (!flag) {
                    logger.info("107消息重复消费,msgId={}", messageExt.getMsgId());
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
                RegCqNetbookInfo record = JSONObject.parseObject(jsonStr, RegCqNetbookInfo.class);
                this.ptln107Service.saveBusinessDate(record);
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        } catch (Exception e) {
            logger.error("107消息消费异常：" + e.getMessage());
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
