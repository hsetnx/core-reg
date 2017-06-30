package com.lefinance.regulation.service;

import com.lefinance.common.constant.RegulatoryContants;
import com.lefinance.common.constant.TransEnum;
import com.lefinance.config.datapush.DataPushConfig;
import com.lefinance.regulation.dao.RegCqFileMapper;
import com.lefinance.regulation.domain.RegCqFile;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author: jingyan
 * @Time: 2017/6/27 16:52
 * @Describe: 报送批次信息
 */
@Service
public class RegCqFileService {

    @Resource
    private RegCqFileMapper regCqFileMapper;
    @Resource
    protected DataPushConfig dataPushConfig;

    /**
     * @Author: jingyan
     * @Time: 2017/6/27 17:07
     * @Describe: 保存文件信息
     */
    public RegCqFile saveCqFileInfo(TransEnum transEnum,String batchGid, String fileName, int tatalSize) {
        RegCqFile regCqFile = new RegCqFile();
        regCqFile.setGid(batchGid);
        regCqFile.setDataType(transEnum.getDataType());
        regCqFile.setFilename(fileName);
        regCqFile.setFilepath(dataPushConfig.getLocalFileDirectory());
        regCqFile.setRecordCount(tatalSize);
        return this.insert(regCqFile);
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/27 18:13
     * @Describe: 保存数据
     */
    public RegCqFile insert(RegCqFile regCqFile) {
        regCqFile.setCreateTime(new Date());
        regCqFile.setUpdateTime(new Date());
        regCqFile.setIsSuccess(Boolean.FALSE);
        regCqFile.setRetryNum(0);
        regCqFile.setNextTime(new Date());
        regCqFile.setStatus(RegulatoryContants.SendStatus.DONE);
        regCqFileMapper.insert(regCqFile);
        return regCqFile;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/27 18:35
     * @Describe: 更新文件表
     */
    public RegCqFile updateByPrimaryKeySelective(RegCqFile regCqFile){
        regCqFile.setUpdateTime(new Date());
        regCqFileMapper.updateByPrimaryKeySelective(regCqFile);
        return regCqFile;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/27 18:14
     * @Describe: 按照批次查询数据
     */
    public RegCqFile selectByGid(String gid){
        return regCqFileMapper.selectByGid(gid);
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/28 15:37
     * @Describe: 按照数据类型和状态查询
     */
    public List<RegCqFile> selectByDataTypeAndStatus(RegCqFile record){
        return regCqFileMapper.selectByDataType(record);
    }
}
