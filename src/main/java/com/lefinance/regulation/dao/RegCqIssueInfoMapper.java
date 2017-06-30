package com.lefinance.regulation.dao;

import com.lefinance.regulation.domain.RegCqIssueInfo;

import java.util.List;

public interface RegCqIssueInfoMapper {

    List<RegCqIssueInfo> selectBatchForUpload(RegCqIssueInfo record);

    int deleteByPrimaryKey(Integer id);

    int insert(RegCqIssueInfo record);

    RegCqIssueInfo selectByPrimaryKey(Integer id);

    List<RegCqIssueInfo> selectAll();

    int updateByPrimaryKey(RegCqIssueInfo record);

    int updateByPrimaryKeySelective(RegCqIssueInfo record);

    int updateByBatchGid(RegCqIssueInfo record);

    List<RegCqIssueInfo> selectByBatchGid(String batchGid);
}