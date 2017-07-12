package com.lefinance.regulation.mqlistener;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.lefinance.common.mq.push.PushListenerAbstract;
import com.lefinance.common.utils.JSONUtil;
import com.lefinance.regulation.domain.RegCqRepayInfo;
import com.lefinance.regulation.service.PTLN104Service;
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
public class Ptln104ConsumerListener extends PushListenerAbstract {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private PTLN104Service ptln104Service;
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
                logger.info("104消息消费,msgBody={}", jsonStr);
                boolean flag = regBusinessDataRecordService.checkMsgRecord(messageExt.getMsgId(), jsonStr);
                if (!flag) {
                    logger.info("104消息重复消费,msgId={}", messageExt.getMsgId());
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
                RegCqRepayInfo record = JSONUtil.fromJson(jsonStr, RegCqRepayInfo.class);
                this.ptln104Service.saveBusinessDate(record);
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        } catch (Exception e) {
            logger.error("104消息消费异常：" + e.getMessage());
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
