package com.lefinance.regulation.model.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by chenyong6 on 2017/4/20.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "tranTimestamp",
        "destBranchNo",
        "sourceBranchNo",
        "sourceType",
        "filePath",
        "tranDate",
        "tranMode",
        "messageType",
        "branchId",
        "messageCode",
        "serviceCode",
        "tranCode",
        "tranType",
        "serverId",
        "wsId",
        "userLang",
        "seqNo",
        "moduleId"
})
public class XmlRequestHeaderEntity {
    @XmlElement(name = "SERVICE_CODE")
    private String serviceCode;
    @XmlElement(name = "TRAN_CODE")
    private String tranCode;
    @XmlElement(name = "TRAN_TYPE")
    private String tranType;
    @XmlElement(name = "TRAN_MODE")
    private String tranMode;
    @XmlElement(name = "TRAN_DATE")
    private String tranDate;
    @XmlElement(name = "TRAN_TIMESTAMP")
    private String tranTimestamp;
    @XmlElement(name = "SERVER_ID")
    private String serverId;
    @XmlElement(name = "WS_ID")
    private String wsId;
    @XmlElement(name = "USER_LANG")
    private String userLang;
    @XmlElement(name = "DEST_BRANCH_NO")
    private String destBranchNo;
    @XmlElement(name = "SOURCE_BRANCH_NO")
    private String sourceBranchNo;
    @XmlElement(name = "MODULE_ID")
    private String moduleId;
    @XmlElement(name = "SOURCE_TYPE")
    private String sourceType;
    @XmlElement(name = "FILE_PATH")
    private String filePath;
    @XmlElement(name = "MESSAGE_TYPE")
    private String messageType;
    @XmlElement(name = "BRANCH_ID")
    private String branchId;
    @XmlElement(name = "MESSAGE_CODE")
    private String messageCode;
    @XmlElement(name = "SEQ_NO")
    private String seqNo;


    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getWsId() {
        return wsId;
    }

    public void setWsId(String wsId) {
        this.wsId = wsId;
    }

    public String getUserLang() {
        return userLang;
    }

    public void setUserLang(String userLang) {
        this.userLang = userLang;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getDestBranchNo() {
        return destBranchNo;
    }

    public void setDestBranchNo(String destBranchNo) {
        this.destBranchNo = destBranchNo;
    }

    public String getSourceBranchNo() {
        return sourceBranchNo;
    }

    public void setSourceBranchNo(String sourceBranchNo) {
        this.sourceBranchNo = sourceBranchNo;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public String getTranMode() {
        return tranMode;
    }

    public void setTranMode(String tranMode) {
        this.tranMode = tranMode;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    @Override
    public String toString() {
        return "XmlRequestHeaderEntity{" +
                "serviceCode='" + serviceCode + '\'' +
                ", tranCode='" + tranCode + '\'' +
                ", tranType='" + tranType + '\'' +
                ", tranMode='" + tranMode + '\'' +
                ", tranDate='" + tranDate + '\'' +
                ", tranTimestamp='" + tranTimestamp + '\'' +
                ", serverId='" + serverId + '\'' +
                ", wsId='" + wsId + '\'' +
                ", userLang='" + userLang + '\'' +
                ", destBranchNo='" + destBranchNo + '\'' +
                ", sourceBranchNo='" + sourceBranchNo + '\'' +
                ", moduleId='" + moduleId + '\'' +
                ", sourceType='" + sourceType + '\'' +
                ", filePath='" + filePath + '\'' +
                ", messageType='" + messageType + '\'' +
                ", branchId='" + branchId + '\'' +
                ", messageCode='" + messageCode + '\'' +
                '}';
    }
}
