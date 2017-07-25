package com.lefinance.regulation.mqlistener;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.lefinance.common.mq.push.PushListenerAbstract;
import com.lefinance.regulation.domain.RegCqPayplanInfo;
import com.lefinance.regulation.service.PTLN105Service;
import com.lefinance.regulation.service.RegBusinessDataRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: jingyan
 * @Time: 2017/6/30 14:54
 * @Describe:
 */
@Component
public class Ptln105ConsumerListener extends PushListenerAbstract {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private PTLN105Service ptln105Service;
    @Resource
    private RegBusinessDataRecordService regBusinessDataRecordService;

    /**
     * @Author: jingyan
     * @Time: 2017/6/30 18:21
     * @Describe: 业务数据入库
     */
    @Override
    public ConsumeConcurrentlyStatus handleMsg(List<MessageExt> messageExts, ConsumeConcurrentlyContext context) {
        try {
            for (MessageExt messageExt : messageExts) {
                String jsonStr = new String(messageExt.getBody());
                logger.info("105消息消费,msgBody={}", jsonStr);
                boolean flag = regBusinessDataRecordService.checkMsgRecord(messageExt.getMsgId(), jsonStr);
                if (!flag) {
                    logger.info("105消息重复消费,msgId={}", messageExt.getMsgId());
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
                RegCqPayplanInfo record = JSONObject.parseObject(jsonStr, RegCqPayplanInfo.class);
                this.ptln105Service.saveBusinessDate(record);
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        } catch (Exception e) {
            logger.error("105消息消费异常：" + e.getMessage());
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
