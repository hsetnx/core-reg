package com.lefinance.regulation.dao;

import com.lefinance.regulation.domain.RegCqMsgLog;
import java.util.List;

public interface RegCqMsgLogMapper {
    int deleteByPrimaryKey(Long serialId);

    int insert(RegCqMsgLog record);

    RegCqMsgLog selectByPrimaryKey(Long serialId);

    List<RegCqMsgLog> selectAll();

    int updateByPrimaryKey(RegCqMsgLog record);
}