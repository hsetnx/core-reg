package com.lefinance.regulation.domain;

import java.math.BigDecimal;
import java.util.Date;

public class RegCqNetbookInfo {
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

    private String loanCate;

    private String customerType;

    private String customerName;

    private String certificateType;

    private String certificateNo;

    private String conCustomerType;

    private String conCustomerName;

    private String conCertificateType;

    private String conCertificateNo;

    private BigDecimal conFee;

    private BigDecimal contractAmount;

    private String contractSignDate;

    private BigDecimal intRate;

    private String remark;

    private String reservedField1;

    private String reservedField2;

    private String reservedField3;

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

    public String getLoanCate() {
        return loanCate;
    }

    public void setLoanCate(String loanCate) {
        this.loanCate = loanCate;
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

    public String getConCustomerType() {
        return conCustomerType;
    }

    public void setConCustomerType(String conCustomerType) {
        this.conCustomerType = conCustomerType;
    }

    public String getConCustomerName() {
        return conCustomerName;
    }

    public void setConCustomerName(String conCustomerName) {
        this.conCustomerName = conCustomerName;
    }

    public String getConCertificateType() {
        return conCertificateType;
    }

    public void setConCertificateType(String conCertificateType) {
        this.conCertificateType = conCertificateType;
    }

    public String getConCertificateNo() {
        return conCertificateNo;
    }

    public void setConCertificateNo(String conCertificateNo) {
        this.conCertificateNo = conCertificateNo;
    }

    public BigDecimal getConFee() {
        return conFee;
    }

    public void setConFee(BigDecimal conFee) {
        this.conFee = conFee;
    }

    public BigDecimal getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(BigDecimal contractAmount) {
        this.contractAmount = contractAmount;
    }

    public String getContractSignDate() {
        return contractSignDate;
    }

    public void setContractSignDate(String contractSignDate) {
        this.contractSignDate = contractSignDate;
    }

    public BigDecimal getIntRate() {
        return intRate;
    }

    public void setIntRate(BigDecimal intRate) {
        this.intRate = intRate;
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