package com.lefinance.regulation.dao;

import com.lefinance.regulation.domain.RegCqIssueInfoHypoledgeInfo;
import java.util.List;

public interface RegCqIssueInfoHypoledgeInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RegCqIssueInfoHypoledgeInfo record);

    RegCqIssueInfoHypoledgeInfo selectByPrimaryKey(Integer id);

    List<RegCqIssueInfoHypoledgeInfo> selectAll();

    int updateByPrimaryKey(RegCqIssueInfoHypoledgeInfo record);

    List<RegCqIssueInfoHypoledgeInfo> selectByIssueInfoGid(String issueInfoGid);
}