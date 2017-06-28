package com.lefinance.regulation.dao;

import com.lefinance.regulation.domain.RegCqIssueInfo;
import java.util.List;

public interface RegCqIssueInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RegCqIssueInfo record);

    RegCqIssueInfo selectByPrimaryKey(Integer id);

    List<RegCqIssueInfo> selectAll();

    int updateByPrimaryKey(RegCqIssueInfo record);
}