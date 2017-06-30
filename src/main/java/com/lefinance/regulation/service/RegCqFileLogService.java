package com.lefinance.regulation.service;

import com.lefinance.common.utils.CommonUtils;
import com.lefinance.regulation.dao.RegCqFileLogMapper;
import com.lefinance.regulation.domain.RegCqFileLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author: jingyan
 * @Time: 2017/6/27 17:09
 * @Describe: 报送记录
 */
@Service
public class RegCqFileLogService {

    @Resource
    private RegCqFileLogMapper regCqFileLogMapper;

    /**
     * @Author: jingyan
     * @Time: 2017/6/27 17:12
     * @Describe: 保存日志信息
     */
    public RegCqFileLog insert(String batchGid, boolean isSuccess, String remark) {
        RegCqFileLog regCqFileLog = new RegCqFileLog();
        regCqFileLog.setBatchGid(batchGid);
        regCqFileLog.setIsSuccess(isSuccess);
        regCqFileLog.setRemark(remark);
        regCqFileLog.setGid(CommonUtils.getUUIDWithoutSeparator());
        regCqFileLog.setCreateTime(new Date());
        regCqFileLog.setUpdateTime(new Date());
        regCqFileLog.setCreateUser("SYSTEM");
        regCqFileLogMapper.insert(regCqFileLog);
        return regCqFileLog;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/28 10:34
     * @Describe: 保存日志信息
     */
    public RegCqFileLog insert(RegCqFileLog regCqFileLog) {
        regCqFileLog.setGid(CommonUtils.getUUIDWithoutSeparator());
        regCqFileLog.setCreateTime(new Date());
        regCqFileLog.setUpdateTime(new Date());
        regCqFileLog.setCreateUser("SYSTEM");
        regCqFileLogMapper.insert(regCqFileLog);
        return regCqFileLog;
    }
}
