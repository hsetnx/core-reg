package com.lefinance.regulation.dao;

import com.lefinance.regulation.domain.RegBusinessDataRecord;

public interface RegBusinessDataRecordMapper {

    int insert(RegBusinessDataRecord record);

    RegBusinessDataRecord selectByMsgId(String msgId);
}