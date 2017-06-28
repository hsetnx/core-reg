package com.lefinance.regulation.domain;

import java.util.Date;

public class RegCqFileLog {
    private Integer id;

    private String gid;

    private Date createTime;

    private Date updateTime;

    private String createUser;

    private String updateUser;

    private String batchGid;

    private String seqNo;

    private String sendData;

    private String returnCode;

    private String returnDesc;

    private String returnData;

    private String transReturnCode;

    private String transReturnDesc;

    private String remark;

    private Boolean isSuccess;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getBatchGid() {
        return batchGid;
    }

    public void setBatchGid(String batchGid) {
        this.batchGid = batchGid;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getSendData() {
        return sendData;
    }

    public void setSendData(String sendData) {
        this.sendData = sendData;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnDesc() {
        return returnDesc;
    }

    public void setReturnDesc(String returnDesc) {
        this.returnDesc = returnDesc;
    }

    public String getReturnData() {
        return returnData;
    }

    public void setReturnData(String returnData) {
        this.returnData = returnData;
    }

    public String getTransReturnCode() {
        return transReturnCode;
    }

    public void setTransReturnCode(String transReturnCode) {
        this.transReturnCode = transReturnCode;
    }

    public String getTransReturnDesc() {
        return transReturnDesc;
    }

    public void setTransReturnDesc(String transReturnDesc) {
        this.transReturnDesc = transReturnDesc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}