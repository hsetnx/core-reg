package com.lefinance.common.utils.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Jingyan
 * @Time: 2017-12-04 11:46
 * @Description:
 */
public class MyLoginThread implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(MyLoginThread.class);
    private String userName;

    @Override
    public void run() {
        logger.info(userName+"-----"+Thread.currentThread().getName());
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}