package com.lefinance.regulation.model.ptln104;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

/**
 * @Author: jingyan
 * @Time: 2017/6/29 15:57
 * @Describe: 还款信息报文实体类
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class RepayInfo {

    @XmlElement(name = "report_type")
    private String reportType;
    @XmlElement(name = "org_code")
    private String orgCode;
    @XmlElement(name = "contract_no")
    private String contractNo;
    @XmlElement(name = "due_bill_no")
    private String dueBillNo;
    @XmlElement(name = "repay_date")
    private String repayDate;
    @XmlElement(name = "counter")
    private String counter;
    @XmlElement(name = "customer_type")
    private String customerType;
    @XmlElement(name = "customer_name")
    private String customerName;
    @XmlElement(name = "certificate_type")
    private String certificateType;
    @XmlElement(name = "certificate_no")
    private String certificateNo;
    @XmlElement(name = "gather_mode")
    private String gatherMode;
    @XmlElement(name = "repay_pri_amt")
    private BigDecimal repayPriAmt;
    @XmlElement(name = "repay_int_amt")
    private BigDecimal repayIntAmt;
    @XmlElement(name = "start_date")
    private String startDate;
    @XmlElement(name = "end_date")
    private String endDate;
    @XmlElement(name = "receipt_type")
    private String receiptType;
    @XmlElement(name = "delay_days")
    private String delayDays;
    @XmlElement(name = "delay_amt")
    private BigDecimal delayAmt;
    @XmlElement(name = "delay_interest")
    private BigDecimal delayInterest;
    @XmlElement(name = "delay_fee")
    private BigDecimal delayFee;
    @XmlElement(name = "pri_plty_rate")
    private BigDecimal priPltyRate;
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

    public String getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
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

    public String getGatherMode() {
        return gatherMode;
    }

    public void setGatherMode(String gatherMode) {
        this.gatherMode = gatherMode;
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

    public String getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(String receiptType) {
        this.receiptType = receiptType;
    }

    public String getDelayDays() {
        return delayDays;
    }

    public void setDelayDays(String delayDays) {
        this.delayDays = delayDays;
    }

    public BigDecimal getDelayAmt() {
        return delayAmt;
    }

    public void setDelayAmt(BigDecimal delayAmt) {
        this.delayAmt = delayAmt;
    }

    public BigDecimal getDelayInterest() {
        return delayInterest;
    }

    public void setDelayInterest(BigDecimal delayInterest) {
        this.delayInterest = delayInterest;
    }

    public BigDecimal getDelayFee() {
        return delayFee;
    }

    public void setDelayFee(BigDecimal delayFee) {
        this.delayFee = delayFee;
    }

    public BigDecimal getPriPltyRate() {
        return priPltyRate;
    }

    public void setPriPltyRate(BigDecimal priPltyRate) {
        this.priPltyRate = priPltyRate;
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
        return "RepayInfo{" +
                ", reportType='" + reportType + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", contractNo='" + contractNo + '\'' +
                ", dueBillNo='" + dueBillNo + '\'' +
                ", repayDate='" + repayDate + '\'' +
                ", counter='" + counter + '\'' +
                ", customerType='" + customerType + '\'' +
                ", customerName='" + customerName + '\'' +
                ", certificateType='" + certificateType + '\'' +
                ", certificateNo='" + certificateNo + '\'' +
                ", gatherMode='" + gatherMode + '\'' +
                ", repayPriAmt=" + repayPriAmt +
                ", repayIntAmt=" + repayIntAmt +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", receiptType='" + receiptType + '\'' +
                ", delayDays='" + delayDays + '\'' +
                ", delayAmt=" + delayAmt +
                ", delayInterest=" + delayInterest +
                ", delayFee=" + delayFee +
                ", priPltyRate=" + priPltyRate +
                ", remark='" + remark + '\'' +
                ", reservedField1='" + reservedField1 + '\'' +
                ", reservedField2='" + reservedField2 + '\'' +
                ", reservedField3='" + reservedField3 + '\'' +
                '}';
    }
}
