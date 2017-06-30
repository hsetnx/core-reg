package com.lefinance.regulation.domain;

import java.math.BigDecimal;
import java.util.Date;

public class RegCqIssueInfo {
    private Integer id;

    private String gid;

    private Date createTime;

    private Date updateTime;

    private String createUser;

    private String updateUser;

    private String returnCode;

    private String returnDesc;

    private String returnData;

    private String transReturnCode;

    private String transReturnDesc;

    private Boolean isSuccess;

    private Date nextTime;

    private Integer retryNum;

    private Integer status;

    private String batchGid;

    private Date reportTime;

    private String reportType;

    private String orgCode;

    private String contractNo;

    private String dueBillNo;

    private String customerType;

    private String customerName;

    private String certificateType;

    private String certificateNo;

    private BigDecimal ddAmt;

    private String loanCate;

    private BigDecimal intRate;

    private BigDecimal priPltyRate;

    private String rateType;

    private String signDate;

    private String ddDate;

    private String matureDate;

    private String extStartDate;

    private String extEndDate;

    private BigDecimal extOustanding;

    private String zone;

    private String guarType;

    private String term;

    private String purpose;

    private String loanObject;

    private String loanObjectSize;

    private String rateCalcMode;

    private String repayMode;

    private String industry;

    private String riskLevel;

    private String issueStatus;

    private BigDecimal fairAmt;

    private String remark;

    private String reservedField1;

    private String reservedField2;

    private String reservedField3;

    @Override
    public String toString() {
        return "RegCqIssueInfo{" +
                "id=" + id +
                ", gid='" + gid + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createUser='" + createUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", returnCode='" + returnCode + '\'' +
                ", returnDesc='" + returnDesc + '\'' +
                ", returnData='" + returnData + '\'' +
                ", transReturnCode='" + transReturnCode + '\'' +
                ", transReturnDesc='" + transReturnDesc + '\'' +
                ", isSuccess=" + isSuccess +
                ", nextTime=" + nextTime +
                ", retryNum=" + retryNum +
                ", status=" + status +
                ", batchGid='" + batchGid + '\'' +
                ", reportTime=" + reportTime +
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
                ", fairAmt=" + fairAmt +
                ", remark='" + remark + '\'' +
                ", reservedField1='" + reservedField1 + '\'' +
                ", reservedField2='" + reservedField2 + '\'' +
                ", reservedField3='" + reservedField3 + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnDesc() {
        return returnDesc;
    }

    public void setReturnDesc(String returnDesc) {
        this.returnDesc = returnDesc;
    }

    public String getReturnData() {
        return returnData;
    }

    public void setReturnData(String returnData) {
        this.returnData = returnData;
    }

    public String getTransReturnCode() {
        return transReturnCode;
    }

    public void setTransReturnCode(String transReturnCode) {
        this.transReturnCode = transReturnCode;
    }

    public String getTransReturnDesc() {
        return transReturnDesc;
    }

    public void setTransReturnDesc(String transReturnDesc) {
        this.transReturnDesc = transReturnDesc;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Date getNextTime() {
        return nextTime;
    }

    public void setNextTime(Date nextTime) {
        this.nextTime = nextTime;
    }

    public Integer getRetryNum() {
        return retryNum;
    }

    public void setRetryNum(Integer retryNum) {
        this.retryNum = retryNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBatchGid() {
        return batchGid;
    }

    public void setBatchGid(String batchGid) {
        this.batchGid = batchGid;
    }

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

    public BigDecimal getFairAmt() {
        return fairAmt;
    }

    public void setFairAmt(BigDecimal fairAmt) {
        this.fairAmt = fairAmt;
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
}