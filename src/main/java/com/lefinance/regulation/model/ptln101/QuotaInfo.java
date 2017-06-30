package com.lefinance.regulation.model.ptln101;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

/**
 * @Author: jingyan
 * @Time: 2017/6/29 15:59
 * @Describe: 贷款额度报文实体类
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "reportType",
        "orgCode",
        "contractNo",
        "contractName",
        "customerType",
        "customerName",
        "certificateType",
        "certificateNo",
        "contractSignDate",
        "contractBeginDate",
        "contractEndDate",
        "contractAmount",
        "ccy",
        "usedAmount",
        "remainAmount",
        "guarType",
        "isCircle",
        "contractStatus",
        "relationManager",
        "remark",
        "reservedField1",
        "reservedField2",
        "reservedField3"
})
public class QuotaInfo {
    @XmlElement(name = "report_type")
    private String reportType;
    @XmlElement(name = "org_code")
    private String orgCode;
    @XmlElement(name = "contract_no")
    private String contractNo;
    @XmlElement(name = "contract_name")
    private String contractName;
    @XmlElement(name = "customer_type")
    private String customerType;
    @XmlElement(name = "customer_name")
    private String customerName;
    @XmlElement(name = "certificate_type")
    private String certificateType;
    @XmlElement(name = "certificate_no")
    private String certificateNo;
    @XmlElement(name = "contract_sign_date")
    private String contractSignDate;
    @XmlElement(name = "contract_begin_date")
    private String contractBeginDate;
    @XmlElement(name = "contract_end_date")
    private String contractEndDate;
    @XmlElement(name = "contract_amount")
    private BigDecimal contractAmount;
    @XmlElement(name = "ccy")
    private String ccy;
    @XmlElement(name = "used_amount")
    private BigDecimal usedAmount;
    @XmlElement(name = "remain_amount")
    private BigDecimal remainAmount;
    @XmlElement(name = "guar_type")
    private String guarType;
    @XmlElement(name = "is_circle")
    private String isCircle;
    @XmlElement(name = "contract_status")
    private String contractStatus;
    @XmlElement(name = "relation_manager")
    private String relationManager;
    @XmlElement(name = "remark")
    private String remark;
    @XmlElement(name = "reserved_field1")
    private String reservedField1;
    @XmlElement(name = "reserved_field2")
    private String reservedField2;
    @XmlElement(name = "reserved_field3")
    private String reservedField3;


    public String getReservedField3() {
        return reservedField3;
    }

    public void setReservedField3(String reservedField3) {
        this.reservedField3 = reservedField3;
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

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
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

    public String getContractSignDate() {
        return contractSignDate;
    }

    public void setContractSignDate(String contractSignDate) {
        this.contractSignDate = contractSignDate;
    }

    public String getContractBeginDate() {
        return contractBeginDate;
    }

    public void setContractBeginDate(String contractBeginDate) {
        this.contractBeginDate = contractBeginDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public BigDecimal getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(BigDecimal contractAmount) {
        this.contractAmount = contractAmount;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public BigDecimal getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(BigDecimal usedAmount) {
        this.usedAmount = usedAmount;
    }

    public BigDecimal getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(BigDecimal remainAmount) {
        this.remainAmount = remainAmount;
    }

    public String getGuarType() {
        return guarType;
    }

    public void setGuarType(String guarType) {
        this.guarType = guarType;
    }

    public String getIsCircle() {
        return isCircle;
    }

    public void setIsCircle(String isCircle) {
        this.isCircle = isCircle;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public String getRelationManager() {
        return relationManager;
    }

    public void setRelationManager(String relationManager) {
        this.relationManager = relationManager;
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


    @Override
    public String toString() {
        return "QuotaInfo{" +
                "reportType='" + reportType + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", contractNo='" + contractNo + '\'' +
                ", contractName='" + contractName + '\'' +
                ", customerType='" + customerType + '\'' +
                ", customerName='" + customerName + '\'' +
                ", certificateType='" + certificateType + '\'' +
                ", certificateNo='" + certificateNo + '\'' +
                ", contractSignDate='" + contractSignDate + '\'' +
                ", contractBeginDate='" + contractBeginDate + '\'' +
                ", contractEndDate='" + contractEndDate + '\'' +
                ", contractAmount=" + contractAmount +
                ", ccy='" + ccy + '\'' +
                ", usedAmount=" + usedAmount +
                ", remainAmount=" + remainAmount +
                ", guarType='" + guarType + '\'' +
                ", isCircle='" + isCircle + '\'' +
                ", contractStatus='" + contractStatus + '\'' +
                ", relationManager='" + relationManager + '\'' +
                ", remark='" + remark + '\'' +
                ", reservedField1='" + reservedField1 + '\'' +
                ", reservedField2='" + reservedField2 + '\'' +
                ", reservedField3='" + reservedField3 + '\'' +
                '}';
    }
}
