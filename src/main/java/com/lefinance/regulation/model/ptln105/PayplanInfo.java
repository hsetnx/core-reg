package com.lefinance.regulation.model.ptln105;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: jingyan
 * @Time: 2017/6/29 15:59
 * @Describe: 还款计划报文实体类
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PayplanInfo {

    @XmlElement(name = "report_type")
    private String reportType;
    @XmlElement(name = "org_code")
    private String orgCode;
    @XmlElement(name = "contract_no")
    private String contractNo;
    @XmlElement(name = "due_bill_no")
    private String dueBillNo;
    @XmlElement(name = "counter")
    private String counter;
    @XmlElement(name = "repay_date")
    private String repayDate;
    @XmlElement(name = "repay_pri_amt")
    private BigDecimal repayPriAmt;
    @XmlElement(name = "repay_int_amt")
    private BigDecimal repayIntAmt;
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

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getDueBillNo() {
        return dueBillNo;
    }

    public void setDueBillNo(String dueBillNo) {
        this.dueBillNo = dueBillNo;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    public String getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    public BigDecimal getRepayPriAmt() {
        return repayPriAmt;
    }

    public void setRepayPriAmt(BigDecimal repayPriAmt) {
        this.repayPriAmt = repayPriAmt;
    }

    public BigDecimal getRepayIntAmt() {
        return repayIntAmt;
    }

    public void setRepayIntAmt(BigDecimal repayIntAmt) {
        this.repayIntAmt = repayIntAmt;
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
        return "PayplanInfo{" +
                ", reportType='" + reportType + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", contractNo='" + contractNo + '\'' +
                ", dueBillNo='" + dueBillNo + '\'' +
                ", counter='" + counter + '\'' +
                ", repayDate='" + repayDate + '\'' +
                ", repayPriAmt=" + repayPriAmt +
                ", repayIntAmt=" + repayIntAmt +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", remark='" + remark + '\'' +
                ", reservedField1='" + reservedField1 + '\'' +
                ", reservedField2='" + reservedField2 + '\'' +
                ", reservedField3='" + reservedField3 + '\'' +
                '}';
    }
}
