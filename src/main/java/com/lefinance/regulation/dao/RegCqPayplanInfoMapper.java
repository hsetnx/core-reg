package com.lefinance.regulation.dao;

import com.lefinance.regulation.domain.RegCqPayplanInfo;

import java.util.List;

public interface RegCqPayplanInfoMapper {

    List<RegCqPayplanInfo> selectBatchForUpload(RegCqPayplanInfo record);

    int deleteByPrimaryKey(Integer id);

    int insert(RegCqPayplanInfo record);

    RegCqPayplanInfo selectByPrimaryKey(Integer id);

    List<RegCqPayplanInfo> selectAll();

    int updateByPrimaryKey(RegCqPayplanInfo record);

    int updateByPrimaryKeySelective(RegCqPayplanInfo record);

    int updateByBatchGid(RegCqPayplanInfo record);

    List<RegCqPayplanInfo> selectByBatchGid(String batchGid);
}