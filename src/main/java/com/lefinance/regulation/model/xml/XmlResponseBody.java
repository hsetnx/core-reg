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
        "bodyEntity",
        "getTx"
})
public class XmlResponseBody {

    @XmlElement(name = "RetTx")
    private XmlResponseBodyEntity bodyEntity;
    @XmlElement(name = "GetTx")
    private XmlResponseBodyGetTx getTx;

    public XmlResponseBodyEntity getBodyEntity() {
        return bodyEntity;
    }

    public void setBodyEntity(XmlResponseBodyEntity bodyEntity) {
        this.bodyEntity = bodyEntity;
    }

    public XmlResponseBodyGetTx getGetTx() {
        return getTx;
    }

    public void setGetTx(XmlResponseBodyGetTx getTx) {
        this.getTx = getTx;
    }


    @Override
    public String toString() {
        return "XmlResponseBody{" +
                "bodyEntity=" + bodyEntity +
                ", getTx=" + getTx +
                '}';
    }




    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(propOrder = {
            "sysErrorcode"
    })
    public static class XmlResponseBodyGetTx{
        @XmlElement(name = "SYS_ERRCODE")
        private String sysErrorcode;

        public String getSysErrorcode() {
            return sysErrorcode;
        }

        public void setSysErrorcode(String sysErrorcode) {
            this.sysErrorcode = sysErrorcode;
        }

        @Override
        public String toString() {
            return "XmlResponseBodyGetTx{" +
                    "sysErrorcode='" + sysErrorcode + '\'' +
                    '}';
        }
    }
}
