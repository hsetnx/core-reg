package com.lefinance.regulation.service;

import com.lefinance.common.utils.PubMethod;
import com.lefinance.regulation.dao.RegBusinessDataRecordMapper;
import com.lefinance.regulation.domain.RegBusinessDataRecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author: jingyan
 * @Time: 2017/6/30 18:02
 * @Describe:
 */
@Service
public class RegBusinessDataRecordService {

    @Resource
    private RegBusinessDataRecordMapper regBusinessDataRecordMapper;

    /**
     * @Author: jingyan
     * @Time: 2017/6/30 18:10
     * @Describe: 消息记录入库
     */
    public boolean checkMsgRecord(String msgId, String msgBody) {
        if (PubMethod.isEmpty(msgId) || PubMethod.isEmpty(msgBody)) {
            return false;
        }
        RegBusinessDataRecord regBusinessDataRecord = regBusinessDataRecordMapper.selectByMsgId(msgId);
        if (null != regBusinessDataRecord) {
            return false;
        }
        RegBusinessDataRecord record = new RegBusinessDataRecord();
        record.setMsgId(msgId);
        record.setCreationTime(new Date());
        record.setMessage(msgBody);
        regBusinessDataRecordMapper.insert(record);
        return true;
    }
}
