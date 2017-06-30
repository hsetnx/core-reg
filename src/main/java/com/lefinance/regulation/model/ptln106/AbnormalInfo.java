package com.lefinance.regulation.model.ptln106;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

/**
 * @Author: jingyan
 * @Time: 2017/6/29 16:02
 * @Describe: 非正常客户
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AbnormalInfo {
    @XmlElement(name = "report_time")
    private Date reportTime;
    @XmlElement(name = "report_type")
    private String reportType;
    @XmlElement(name = "org_code")
    private String orgCode;
    @XmlElement(name = "customer_type")
    private String customerType;
    @XmlElement(name = "customer_name")
    private String customerName;
    @XmlElement(name = "certificate_type")
    private String certificateType;
    @XmlElement(name = "certificate_no")
    private String certificateNo;
    @XmlElement(name = "reason")
    private String reason;
    @XmlElement(name = "industry")
    private String industry;
    @XmlElement(name = "zone")
    private String zone;
    @XmlElement(name = "start_date")
    private String startDate;
    @XmlElement(name = "end_date")
    private String endDate;
    @XmlElement(name = "remark")
    private String remark;
    @XmlElement(name = "reserved_field1")
    private String reservedField1;
    @XmlElement(name = "reserved_field2")
    private String reservedField2;
    @XmlElement(name = "reserved_field3")
    private String reservedField3;

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

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
        return "AbnormalInfo{" +
                "reportTime=" + reportTime +
                ", reportType='" + reportType + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", customerType='" + customerType + '\'' +
                ", customerName='" + customerName + '\'' +
                ", certificateType='" + certificateType + '\'' +
                ", certificateNo='" + certificateNo + '\'' +
                ", reason='" + reason + '\'' +
                ", industry='" + industry + '\'' +
                ", zone='" + zone + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", remark='" + remark + '\'' +
                ", reservedField1='" + reservedField1 + '\'' +
                ", reservedField2='" + reservedField2 + '\'' +
                ", reservedField3='" + reservedField3 + '\'' +
                '}';
    }
}
