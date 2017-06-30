package com.lefinance.regulation.dao;

import com.lefinance.regulation.domain.RegCqRepayInfo;

import java.util.List;

public interface RegCqRepayInfoMapper {

    List<RegCqRepayInfo> selectBatchForUpload(RegCqRepayInfo record);

    int deleteByPrimaryKey(Integer id);

    int insert(RegCqRepayInfo record);

    RegCqRepayInfo selectByPrimaryKey(Integer id);

    List<RegCqRepayInfo> selectAll();

    int updateByPrimaryKey(RegCqRepayInfo record);

    int updateByPrimaryKeySelective(RegCqRepayInfo record);

    int updateByBatchGid(RegCqRepayInfo record);

    List<RegCqRepayInfo> selectByBatchGid(String batchGid);
}