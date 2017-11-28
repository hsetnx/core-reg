package com.lefinance.aop;

/**
 * @Author: Jingyan
 * @Time: 2017-11-28 16:55
 * @Description:
 */
public class BaseVo {

    private String uuid;
    private boolean isSuccess=false;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}