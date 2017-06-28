package com.lefinance.regulation.domain;

import java.util.Date;

public class RegCqMsgLog {
    private Long serialId;

    private String msgId;

    private String msgTag;

    private String msgBod;

    private Date creationTime;

    public Long getSerialId() {
        return serialId;
    }

    public void setSerialId(Long serialId) {
        this.serialId = serialId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgTag() {
        return msgTag;
    }

    public void setMsgTag(String msgTag) {
        this.msgTag = msgTag;
    }

    public String getMsgBod() {
        return msgBod;
    }

    public void setMsgBod(String msgBod) {
        this.msgBod = msgBod;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}