package com.lefinance.regulation.dao;

import com.lefinance.regulation.domain.RegCqNetbookInfo;

import java.util.List;

public interface RegCqNetbookInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RegCqNetbookInfo record);

    RegCqNetbookInfo selectByPrimaryKey(Integer id);

    List<RegCqNetbookInfo> selectAll();

    int updateByPrimaryKey(RegCqNetbookInfo record);

    int updateByPrimaryKeySelective(RegCqNetbookInfo record);

    List<RegCqNetbookInfo> selectBatchForUpload(RegCqNetbookInfo record);

    int updateByBatchGid(RegCqNetbookInfo record);

    List<RegCqNetbookInfo> selectByBatchGid(String batchGid);
}