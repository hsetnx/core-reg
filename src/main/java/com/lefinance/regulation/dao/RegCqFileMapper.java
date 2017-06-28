package com.lefinance.regulation.dao;

import com.lefinance.regulation.domain.RegCqFile;

import java.util.List;

public interface RegCqFileMapper {

    /**
     * @Author: jingyan
     * @Time: 2017/6/27 14:21
     * @Describe: 按照批次查询
     */
    RegCqFile selectByGid(String gid);

    int deleteByPrimaryKey(Integer id);

    int insert(RegCqFile record);

    RegCqFile selectByPrimaryKey(Integer id);

    List<RegCqFile> selectAll();

    int updateByPrimaryKey(RegCqFile record);

    int updateByPrimaryKeySelective(RegCqFile record);

    List<RegCqFile> selectByDataType(RegCqFile record);
}