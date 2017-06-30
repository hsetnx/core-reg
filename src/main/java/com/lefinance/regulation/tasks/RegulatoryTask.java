package com.lefinance.regulation.tasks;

import com.lefinance.common.constant.TransEnum;
import com.lefinance.regulation.service.PTLN102Service;
import com.lefinance.regulation.service.PTLN103Service;
import com.lefinance.regulation.service.PTLN104Service;
import com.lefinance.regulation.service.PTLN105Service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: jingyan
 * @Time: 2017/6/27 14:37
 * @Describe: 上报定时任务
 */
@Component
public class RegulatoryTask {

    @Resource
    @Qualifier("ptln102Service")
    private PTLN102Service ptln102Service;
    @Resource
    @Qualifier("ptln103Service")
    private PTLN103Service ptln103Service;
    @Resource
    @Qualifier("ptln104Service")
    private PTLN104Service ptln104Service;
    @Resource
    @Qualifier("ptln105Service")
    private PTLN105Service ptln105Service;

    /**
     * @Author: jingyan
     * @Time: 2017/6/29 16:06
     * @Describe: 上报任务
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public void upload(){
        this.ptln102Service.reportSupervise(TransEnum.PTLN102);
        this.ptln103Service.reportSupervise(TransEnum.PTLN103);
        this.ptln104Service.reportSupervise(TransEnum.PTLN104);
        this.ptln105Service.reportSupervise(TransEnum.PTLN105);
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/29 16:07
     * @Describe: 上报查询任务
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public void querry(){
        this.ptln102Service.queryResult(TransEnum.PTLN102.getDataType());
        this.ptln103Service.queryResult(TransEnum.PTLN103.getDataType());
        this.ptln104Service.queryResult(TransEnum.PTLN104.getDataType());
        this.ptln105Service.queryResult(TransEnum.PTLN105.getDataType());
    }
}
