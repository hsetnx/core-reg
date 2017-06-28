package com.lefinance.regulation.tasks;

import com.lefinance.common.constant.TransEnum;
import com.lefinance.regulation.service.PTLN102Service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: jingyan
 * @Time: 2017/6/27 14:37
 * @Describe:
 */
@Component
public class RegulatoryTask {

    @Resource
    @Qualifier("ptln102Service")
    private PTLN102Service ptln102Service;


    @Scheduled(cron = "0 0/1 * * * ?")
    public void upload(){
        this.ptln102Service.reportSupervise(TransEnum.PTLN102);
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void querry(){
        this.ptln102Service.queryResult(TransEnum.PTLN102.getDataType());
    }
}
