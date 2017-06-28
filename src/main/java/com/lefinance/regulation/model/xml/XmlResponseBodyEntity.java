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
        "netSignId",
//        "msgCode",
//        "msgInfo",
        "reservedField1",
        "reservedField2",
        "reservedField3"
})
public class XmlResponseBodyEntity {
    @XmlElement(name = "NET_SIGN_ID")
    private String netSignId;
//    @XmlElement(name = "MSG_CODE")
//    private String msgCode;
//    @XmlElement(name = "MSG_INFO")
//    private String msgInfo;
    @XmlElement(name = "RESERVED_FIELD1")
    private String reservedField1;
    @XmlElement(name = "RESERVED_FIELD2")
    private String reservedField2;
    @XmlElement(name = "RESERVED_FIELD3")
    private String reservedField3;


    public String getNetSignId() {
        return netSignId;
    }

    public void setNetSignId(String netSignId) {
        this.netSignId = netSignId;
    }

    //    public String getMsgCode() {
//        return msgCode;
//    }
//    public void setMsgCode(String msgCode) {
//        this.msgCode = msgCode;
//    }
//    public String getMsgInfo() {
//        return msgInfo;
//    }
//    public void setMsgInfo(String msgInfo) {
//        this.msgInfo = msgInfo;
//    }
    public String getReservedField1() {
        return reservedField1;
    }
    public void setReservedField1(String reservedField1) {
        this.reservedField1 = reservedField1;
    }
    public String getReservedField2() {
        return reservedField2;
    }
    public void setReservedField2(String reservedField2) {
        this.reservedField2 = reservedField2;
    }
    public String getReservedField3() {
        return reservedField3;
    }
    public void setReservedField3(String reservedField3) {
        this.reservedField3 = reservedField3;
    }

    @Override
    public String toString() {
        return "XmlResponseBodyEntity{" +
                "netSignId='" + netSignId + '\'' +
                ", reservedField1='" + reservedField1 + '\'' +
                ", reservedField2='" + reservedField2 + '\'' +
                ", reservedField3='" + reservedField3 + '\'' +
                '}';
    }
}
