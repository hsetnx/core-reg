package com.lefinance.regulation.dao;

import com.lefinance.regulation.domain.RegCqContractInfoCoCustomerInfo;
import java.util.List;

public interface RegCqContractInfoCoCustomerInfoMapper {

    /**
     * @Author: jingyan
     * @Time: 2017/6/27 15:43
     * @Describe: 查询一笔合同的信息
     */
    List<RegCqContractInfoCoCustomerInfo> selectByContractInfoGid(String contractInfoGid);

    int deleteByPrimaryKey(Integer id);

    int insert(RegCqContractInfoCoCustomerInfo record);

    RegCqContractInfoCoCustomerInfo selectByPrimaryKey(Integer id);

    List<RegCqContractInfoCoCustomerInfo> selectAll();

    int updateByPrimaryKey(RegCqContractInfoCoCustomerInfo record);
}