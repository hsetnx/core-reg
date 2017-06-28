package com.lefinance.regulation.model.ptln102;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenyong6 on 2017/5/4.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CoCustomerInfo {
    @XmlElement(name = "customer_type")
    private String customerType;
    @XmlElement(name = "customer_name")
    private String customerName;
    @XmlElement(name = "certificate_type")
    private String certificateType;
    @XmlElement(name = "certificate_no")
    private String certificateNo;
    @XmlElement(name = "linkman")
    private String linkman;
    @XmlElement(name = "telephone")
    private String telephone;


    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "CoCustomerInfo{" +
                "customerType='" + customerType + '\'' +
                ", customerName='" + customerName + '\'' +
                ", certificateType='" + certificateType + '\'' +
                ", certificateNo='" + certificateNo + '\'' +
                ", linkman='" + linkman + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
