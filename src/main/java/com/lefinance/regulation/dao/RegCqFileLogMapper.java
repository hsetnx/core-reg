package com.lefinance.regulation.dao;

import com.lefinance.regulation.domain.RegCqFileLog;
import java.util.List;

public interface RegCqFileLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RegCqFileLog record);

    RegCqFileLog selectByPrimaryKey(Integer id);

    List<RegCqFileLog> selectAll();

    int updateByPrimaryKey(RegCqFileLog record);
}