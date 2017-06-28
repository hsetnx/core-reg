package com.lefinance.regulation.dao;

import com.lefinance.regulation.domain.RegCqRepayInfo;
import java.util.List;

public interface RegCqRepayInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RegCqRepayInfo record);

    RegCqRepayInfo selectByPrimaryKey(Integer id);

    List<RegCqRepayInfo> selectAll();

    int updateByPrimaryKey(RegCqRepayInfo record);
}