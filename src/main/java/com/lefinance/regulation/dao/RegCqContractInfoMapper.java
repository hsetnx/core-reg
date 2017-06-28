package com.lefinance.regulation.dao;

import com.lefinance.regulation.domain.RegCqContractInfo;

import java.util.List;

public interface RegCqContractInfoMapper {

    /**
     * @Author: jingyan
     * @Time: 2017/6/27 14:55
     * @Describe: 查询一批数据上报
     */
    List<RegCqContractInfo> selectBatchForUpload(RegCqContractInfo regCqContractInfo);

    int deleteByPrimaryKey(Integer id);

    int insert(RegCqContractInfo record);

    RegCqContractInfo selectByPrimaryKey(Integer id);

    List<RegCqContractInfo> selectAll();

    int updateByPrimaryKey(RegCqContractInfo record);

    int updateByPrimaryKeySelective(RegCqContractInfo record);

    int updateByBatchGid(RegCqContractInfo record);

    List<RegCqContractInfo> selectByBatchGid(String batchGid);
}