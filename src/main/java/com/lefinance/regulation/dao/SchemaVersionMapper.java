package com.lefinance.regulation.dao;

import com.lefinance.regulation.domain.SchemaVersion;
import java.util.List;

public interface SchemaVersionMapper {
    int deleteByPrimaryKey(Integer installedRank);

    int insert(SchemaVersion record);

    SchemaVersion selectByPrimaryKey(Integer installedRank);

    List<SchemaVersion> selectAll();

    int updateByPrimaryKey(SchemaVersion record);
}