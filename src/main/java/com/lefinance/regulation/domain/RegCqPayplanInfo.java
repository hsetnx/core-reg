package com.lefinance.regulation.domain;

import java.math.BigDecimal;
import java.util.Date;

public class RegCqPayplanInfo {
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

    private String counter;

    private String repayDate;

    private BigDecimal repayPriAmt;

    private BigDecimal repayIntAmt;

    private String startDate;

    private String endDate;

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
}