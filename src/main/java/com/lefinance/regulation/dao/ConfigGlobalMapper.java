package com.lefinance.regulation.dao;

import com.lefinance.regulation.domain.ConfigGlobal;
import java.util.List;

public interface ConfigGlobalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConfigGlobal record);

    ConfigGlobal selectByPrimaryKey(Integer id);

    List<ConfigGlobal> selectAll();

    int updateByPrimaryKey(ConfigGlobal record);
}