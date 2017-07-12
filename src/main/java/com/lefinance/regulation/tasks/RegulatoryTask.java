package com.lefinance.regulation.tasks;

import com.lefinance.common.constant.TransEnum;
import com.lefinance.regulation.service.*;
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
    @Resource
    @Qualifier("ptln107Service")
    private PTLN107Service ptln107Service;

    /**
     * @Author: jingyan
     * @Time: 2017/6/29 16:06
     * @Describe: 上报任务 每月2号 [8：01-8：10] 每隔10秒执行一次
     */
    @Scheduled(cron = "0/10 1-10 8 2 * ?")
    public void reportSupervise107() {
        this.ptln107Service.reportSupervise(TransEnum.PTLN107);
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/29 16:06
     * @Describe: 上报任务 每月2号 [8：11-8：20] 每隔10秒执行一次
     */
    @Scheduled(cron = "0/10 11-20 8 2 * ?")
    public void reportSupervise102() {
        this.ptln102Service.reportSupervise(TransEnum.PTLN102);
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/29 16:06
     * @Describe: 上报任务 每月2号 [8：21-8：30] 每隔10秒执行一次
     */
    @Scheduled(cron = "0/10 21-30 8 2 * ?")
    public void reportSupervise103() {
        this.ptln103Service.reportSupervise(TransEnum.PTLN103);
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/29 16:06
     * @Describe: 上报任务 每月2号 [8：31-8：40] 每隔10秒执行一次
     */
    @Scheduled(cron = "0/10 31-40 8 2 * ?")
    public void reportSupervise105() {
        this.ptln105Service.reportSupervise(TransEnum.PTLN105);
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/29 16:06
     * @Describe: 上报任务 每月2号 [8：41-8：50] 每隔10秒执行一次
     */
    @Scheduled(cron = "0/10 41-50 8 2 * ?")
    public void reportSupervise104() {
        this.ptln104Service.reportSupervise(TransEnum.PTLN104);
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/29 16:07
     * @Describe: 上报查询任务
     */
    @Scheduled(cron = "0/10 * 8-9 2 * ?")
    public void querry() {
        this.ptln107Service.queryResult(TransEnum.PTLN107.getDataType());
        this.ptln102Service.queryResult(TransEnum.PTLN102.getDataType());
        this.ptln103Service.queryResult(TransEnum.PTLN103.getDataType());
        this.ptln105Service.queryResult(TransEnum.PTLN105.getDataType());
        this.ptln104Service.queryResult(TransEnum.PTLN104.getDataType());
    }
}