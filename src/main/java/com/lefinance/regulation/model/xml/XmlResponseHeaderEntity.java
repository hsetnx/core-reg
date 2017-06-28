package com.lefinance.regulation.model.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created by chenyong6 on 2017/4/20.
 */
@XmlAccessorType(XmlAccessType.FIELD)
//序列化属性，名称与属性名对应
@XmlType(propOrder = {
        "retStatus",
        "branchId",
        "sourceBranchNo",
        "destBranchNo",
        "messageType",
        "messageCode",
        "serviceCode",
        "tranDate",
        "tranTimestamp",
        "seqNo",
        "filePath",
        "ret"
})
public class XmlResponseHeaderEntity {
    @XmlElement(name = "RET_STATUS")
    private String retStatus;
    @XmlElement(name = "BRANCH_ID")
    private String branchId;
    @XmlElement(name = "SOURCE_BRANCH_NO")
    private String sourceBranchNo;
    @XmlElement(name = "DEST_BRANCH_NO")
    private String destBranchNo;
    @XmlElement(name = "MESSAGE_TYPE")
    private String messageType;
    @XmlElement(name = "MESSAGE_CODE")
    private String messageCode;
    @XmlElement(name = "SERVICE_CODE")
    private String serviceCode;
    @XmlElement(name = "TRAN_DATE")
    private String tranDate;
    @XmlElement(name = "TRAN_TIMESTAMP")
    private String tranTimestamp;
    @XmlElement(name = "SEQ_NO")
    private String seqNo;
    @XmlElement(name = "FILE_PATH")
    private String filePath;
    @XmlElement(name = "RET")
    private RET ret;
    public String getRetStatus() {
        return retStatus;
    }

    public void setRetStatus(String retStatus) {
        this.retStatus = retStatus;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getSourceBranchNo() {
        return sourceBranchNo;
    }

    public void setSourceBranchNo(String sourceBranchNo) {
        this.sourceBranchNo = sourceBranchNo;
    }

    public String getDestBranchNo() {
        return destBranchNo;
    }

    public void setDestBranchNo(String destBranchNo) {
        this.destBranchNo = destBranchNo;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
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

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public RET getRet() {
        return ret;
    }

    public void setRet(RET ret) {
        this.ret = ret;
    }

    @Override
    public String toString() {
        return "XmlResponseHeaderEntity{" +
                "retStatus='" + retStatus + '\'' +
                ", branchId='" + branchId + '\'' +
                ", sourceBranchNo='" + sourceBranchNo + '\'' +
                ", destBranchNo='" + destBranchNo + '\'' +
                ", messageType='" + messageType + '\'' +
                ", messageCode='" + messageCode + '\'' +
                ", serviceCode='" + serviceCode + '\'' +
                ", tranDate='" + tranDate + '\'' +
                ", tranTimestamp='" + tranTimestamp + '\'' +
                ", seqNo='" + seqNo + '\'' +
                ", filePath='" + filePath + '\'' +
                ", ret=" + ret +
                '}';
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(propOrder = {
            "retCode",
            "retMsg"
    })
    public static class RET implements Serializable {
        @XmlElement(name = "RET_CODE")
        private String retCode;
        @XmlElement(name = "RET_MSG")
        private String retMsg;
        public String getRetCode() {
            return retCode;
        }
        public void setRetCode(String retCode) {
            this.retCode = retCode;
        }
        public String getRetMsg() {
            return retMsg;
        }
        public void setRetMsg(String retMsg) {
            this.retMsg = retMsg;
        }

        @Override
        public String toString() {
            return "RET{" +
                    "retCode='" + retCode + '\'' +
                    ", retMsg='" + retMsg + '\'' +
                    '}';
        }
    }

}




