package com.lefinance.regulation.model.ptln103;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: jingyan
 * @Time: 2017/6/29 15:58
 * @Describe: 贷款发放报文实体类
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class IssueInfo {
    @XmlElement(name = "report_type")
    private String reportType;
    @XmlElement(name = "org_code")
    private String orgCode;
    @XmlElement(name = "contract_no")
    private String contractNo;
    @XmlElement(name = "due_bill_no")
    private String dueBillNo;
    @XmlElement(name = "customer_type")
    private String customerType;
    @XmlElement(name = "customer_name")
    private String customerName;
    @XmlElement(name = "certificate_type")
    private String certificateType;
    @XmlElement(name = "certificate_no")
    private String certificateNo;
    @XmlElement(name = "dd_amt")
    private BigDecimal ddAmt;
    @XmlElement(name = "loan_cate")
    private String loanCate;
    @XmlElement(name = "int_rate")
    private BigDecimal intRate;
    @XmlElement(name = "pri_plty_rate")
    private BigDecimal priPltyRate;
    @XmlElement(name = "rate_type")
    private String rateType;
    @XmlElement(name = "sign_date")
    private String signDate;
    @XmlElement(name = "dd_date")
    private String ddDate;
    @XmlElement(name = "mature_date")
    private String matureDate;
    @XmlElement(name = "ext_start_date")
    private String extStartDate;
    @XmlElement(name = "ext_end_date")
    private String extEndDate;
    @XmlElement(name = "ext_oustanding")
    private BigDecimal extOustanding;
    @XmlElement(name = "zone")
    private String zone;
    @XmlElement(name = "guar_type")
    private String guarType;
    @XmlElement(name = "term")
    private String term;
    @XmlElement(name = "purpose")
    private String purpose;
    @XmlElement(name = "loan_object")
    private String loanObject;
    @XmlElement(name = "loan_object_size")
    private String loanObjectSize;
    @XmlElement(name = "rate_calc_mode")
    private String rateCalcMode;
    @XmlElement(name = "repay_mode")
    private String repayMode;
    @XmlElement(name = "industry")
    private String industry;
    @XmlElement(name = "risk_level")
    private String riskLevel;
    @XmlElement(name = "issue_status")
    private String issueStatus;
    @XmlElement(name = "hypopledge_info")
    private List<HypopledgeInfo> hypopledgeInfoList;
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

    public BigDecimal getDdAmt() {
        return ddAmt;
    }

    public void setDdAmt(BigDecimal ddAmt) {
        this.ddAmt = ddAmt;
    }

    public String getLoanCate() {
        return loanCate;
    }

    public void setLoanCate(String loanCate) {
        this.loanCate = loanCate;
    }

    public BigDecimal getIntRate() {
        return intRate;
    }

    public void setIntRate(BigDecimal intRate) {
        this.intRate = intRate;
    }

    public BigDecimal getPriPltyRate() {
        return priPltyRate;
    }

    public void setPriPltyRate(BigDecimal priPltyRate) {
        this.priPltyRate = priPltyRate;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public String getDdDate() {
        return ddDate;
    }

    public void setDdDate(String ddDate) {
        this.ddDate = ddDate;
    }

    public String getMatureDate() {
        return matureDate;
    }

    public void setMatureDate(String matureDate) {
        this.matureDate = matureDate;
    }

    public String getExtStartDate() {
        return extStartDate;
    }

    public void setExtStartDate(String extStartDate) {
        this.extStartDate = extStartDate;
    }

    public String getExtEndDate() {
        return extEndDate;
    }

    public void setExtEndDate(String extEndDate) {
        this.extEndDate = extEndDate;
    }

    public BigDecimal getExtOustanding() {
        return extOustanding;
    }

    public void setExtOustanding(BigDecimal extOustanding) {
        this.extOustanding = extOustanding;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getGuarType() {
        return guarType;
    }

    public void setGuarType(String guarType) {
        this.guarType = guarType;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getLoanObject() {
        return loanObject;
    }

    public void setLoanObject(String loanObject) {
        this.loanObject = loanObject;
    }

    public String getLoanObjectSize() {
        return loanObjectSize;
    }

    public void setLoanObjectSize(String loanObjectSize) {
        this.loanObjectSize = loanObjectSize;
    }

    public String getRateCalcMode() {
        return rateCalcMode;
    }

    public void setRateCalcMode(String rateCalcMode) {
        this.rateCalcMode = rateCalcMode;
    }

    public String getRepayMode() {
        return repayMode;
    }

    public void setRepayMode(String repayMode) {
        this.repayMode = repayMode;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }

    public List<HypopledgeInfo> getHypopledgeInfoList() {
        return hypopledgeInfoList;
    }

    public void setHypopledgeInfoList(List<HypopledgeInfo> hypopledgeInfoList) {
        this.hypopledgeInfoList = hypopledgeInfoList;
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
        return "IssueInfo{" +
                ", reportType='" + reportType + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", contractNo='" + contractNo + '\'' +
                ", dueBillNo='" + dueBillNo + '\'' +
                ", customerType='" + customerType + '\'' +
                ", customerName='" + customerName + '\'' +
                ", certificateType='" + certificateType + '\'' +
                ", certificateNo='" + certificateNo + '\'' +
                ", ddAmt=" + ddAmt +
                ", loanCate='" + loanCate + '\'' +
                ", intRate=" + intRate +
                ", priPltyRate=" + priPltyRate +
                ", rateType='" + rateType + '\'' +
                ", signDate='" + signDate + '\'' +
                ", ddDate='" + ddDate + '\'' +
                ", matureDate='" + matureDate + '\'' +
                ", extStartDate='" + extStartDate + '\'' +
                ", extEndDate='" + extEndDate + '\'' +
                ", extOustanding=" + extOustanding +
                ", zone='" + zone + '\'' +
                ", guarType='" + guarType + '\'' +
                ", term='" + term + '\'' +
                ", purpose='" + purpose + '\'' +
                ", loanObject='" + loanObject + '\'' +
                ", loanObjectSize='" + loanObjectSize + '\'' +
                ", rateCalcMode='" + rateCalcMode + '\'' +
                ", repayMode='" + repayMode + '\'' +
                ", industry='" + industry + '\'' +
                ", riskLevel='" + riskLevel + '\'' +
                ", issueStatus='" + issueStatus + '\'' +
                ", hypopledgeInfoList=" + hypopledgeInfoList +
                ", reservedField1='" + reservedField1 + '\'' +
                ", reservedField2='" + reservedField2 + '\'' +
                ", reservedField3='" + reservedField3 + '\'' +
                '}';
    }
}
