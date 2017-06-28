package com.lefinance.regulation.dao;

import com.lefinance.regulation.domain.RegCqAbnormalInfo;
import java.util.List;

public interface RegCqAbnormalInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RegCqAbnormalInfo record);

    RegCqAbnormalInfo selectByPrimaryKey(Integer id);

    List<RegCqAbnormalInfo> selectAll();

    int updateByPrimaryKey(RegCqAbnormalInfo record);
}