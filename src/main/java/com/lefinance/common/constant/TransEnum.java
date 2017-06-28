package com.lefinance.common.constant;

/**
 * Created by chenyong6 on 2017/4/25.
 */
public enum TransEnum {

    PTLN001(RegulatoryContants.TransCode.PTLN001,
            RegulatoryContants.TransMode.ONLINE,
            "",
            RegulatoryContants.MessageType.TYPE_1200,
            RegulatoryContants.MessageCode.CODE_0001,
            RegulatoryContants.ServiceCode.SVR_FILE, "实时网签"),
    PTLN101(RegulatoryContants.TransCode.PTLN101,
            RegulatoryContants.TransMode.ASYNC,
            RegulatoryContants.DataType.QUOTA_INFO,
            RegulatoryContants.MessageType.TYPE_1220,
            RegulatoryContants.MessageCode.CODE_0101,
            RegulatoryContants.ServiceCode.SVR_FILE, "授信额度信息上报"),
    PTLN102(RegulatoryContants.TransCode.PTLN102,
            RegulatoryContants.TransMode.ASYNC,
            RegulatoryContants.DataType.CONTRACT_INFO,
            RegulatoryContants.MessageType.TYPE_1220,
            RegulatoryContants.MessageCode.CODE_0102,
            RegulatoryContants.ServiceCode.SVR_FILE, "贷款合同信息上报"),
    PTLN103(RegulatoryContants.TransCode.PTLN103,
            RegulatoryContants.TransMode.ASYNC,
            RegulatoryContants.DataType.ISSUE_INFO,
            RegulatoryContants.MessageType.TYPE_1220,
            RegulatoryContants.MessageCode.CODE_0103,
            RegulatoryContants.ServiceCode.SVR_FILE, "贷款发放信息上报"),
    PTLN104(RegulatoryContants.TransCode.PTLN104,
            RegulatoryContants.TransMode.ASYNC,
            RegulatoryContants.DataType.REPAY_INFO,
            RegulatoryContants.MessageType.TYPE_1220,
            RegulatoryContants.MessageCode.CODE_0104,
            RegulatoryContants.ServiceCode.SVR_FILE, "贷款回收信息上报"),
    PTLN105(RegulatoryContants.TransCode.PTLN105,
            RegulatoryContants.TransMode.ASYNC,
            RegulatoryContants.DataType.PAYPLAN_INFO,
            RegulatoryContants.MessageType.TYPE_1220,
            RegulatoryContants.MessageCode.CODE_0105,
            RegulatoryContants.ServiceCode.SVR_FILE, "还款计划信息上报"),
    PTLN106(RegulatoryContants.TransCode.PTLN106,
            RegulatoryContants.TransMode.ASYNC,
            RegulatoryContants.DataType.ABNORMAL_INFO,
            RegulatoryContants.MessageType.TYPE_1220,
            RegulatoryContants.MessageCode.CODE_0106,
            RegulatoryContants.ServiceCode.SVR_FILE, "非正常客户信息上报"),
    PTLN107(RegulatoryContants.TransCode.PTLN107,
            RegulatoryContants.TransMode.ASYNC,
            RegulatoryContants.DataType.NETBOOK_INFO,
            RegulatoryContants.MessageType.TYPE_1220,
            RegulatoryContants.MessageCode.CODE_0103,
            RegulatoryContants.ServiceCode.SVR_FILE, "网签文件上报"),
    PTLN199(RegulatoryContants.TransCode.PTLN199,
            RegulatoryContants.TransMode.ONLINE,
            "",
            RegulatoryContants.MessageType.TYPE_1220,
            RegulatoryContants.MessageCode.CODE_0199,
            RegulatoryContants.ServiceCode.SVR_FILE, "上报信息查询");


    private String transCode;
    private String transMode;
    private String dataType;
    private String msgType;
    private String msgCode;
    private String serviceCode;
    private String remark;

    private TransEnum(String transCode, String transMode, String dataType, String msgType, String msgCode, String serviceCode, String remark){
        this.transCode = transCode;
        this.transMode = transMode;
        this.dataType = dataType;
        this.msgType = msgType;
        this.msgCode = msgCode;
        this.serviceCode = serviceCode;
        this.remark = remark;
    }

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getTransMode() {
        return transMode;
    }

    public void setTransMode(String transMode) {
        this.transMode = transMode;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "TransEnum{" +
                "transCode='" + transCode + '\'' +
                ", transMode='" + transMode + '\'' +
                ", dataType='" + dataType + '\'' +
                ", msgType='" + msgType + '\'' +
                ", msgCode='" + msgCode + '\'' +
                ", serviceCode='" + serviceCode + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
