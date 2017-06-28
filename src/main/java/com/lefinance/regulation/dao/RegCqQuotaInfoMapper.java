package com.lefinance.regulation.dao;

import com.lefinance.regulation.domain.RegCqQuotaInfo;
import java.util.List;

public interface RegCqQuotaInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RegCqQuotaInfo record);

    RegCqQuotaInfo selectByPrimaryKey(Integer id);

    List<RegCqQuotaInfo> selectAll();

    int updateByPrimaryKey(RegCqQuotaInfo record);
}