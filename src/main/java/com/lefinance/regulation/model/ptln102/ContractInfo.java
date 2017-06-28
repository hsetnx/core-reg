package com.lefinance.regulation.model.ptln102;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by chenyong6 on 2017/4/25.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ContractInfo {
    @XmlElement(name = "report_type")
    private String reportType;
    @XmlElement(name = "org_code")
    private String orgCode;
    @XmlElement(name = "contract_no")
    private String contractNo;
    @XmlElement(name = "loan_cate")
    private String loanCate;
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
    @XmlElement(name = "linkman")
    private String linkman;
    @XmlElement(name = "telephone")
    private String telephone;
    @XmlElement(name = "loan_object")
    private String loanObject;
    @XmlElement(name = "loan_object_size")
    private String loanObjectSize;
    @XmlElement(name = "contract_sign_date")
    private String contractSignDate;
    @XmlElement(name = "contract_begin_date")
    private String contractBeginDate;
    @XmlElement(name = "contract_end_date")
    private String contractEndDate;
    @XmlElement(name = "contract_amount")
    private BigDecimal contractAmount;
    @XmlElement(name = "outstanding")
    private BigDecimal outstanding;
    @XmlElement(name = "guar_type")
    private String guarType;
    @XmlElement(name = "ccy")
    private String ccy;
    @XmlElement(name = "is_real_quota_loan")
    private String isRealQuotaLoan;
    @XmlElement(name = "real_quota_no")
    private String realQuotaNo;
    @XmlElement(name = "int_rate")
    private BigDecimal intRate;
    @XmlElement(name = "pri_plty_rate")
    private BigDecimal priPltyRate;
    @XmlElement(name = "contract_status")
    private String contractStatus;
    @XmlElement(name = "relation_manager")
    private String relationManager;
    @XmlElement(name = "dispute_scheme")
    private String disputeScheme;
    @XmlElement(name = "con_customer_type")
    private String conCustomerType;
    @XmlElement(name = "con_customer_name")
    private String conCustomerName;
    @XmlElement(name = "con_certificate_type")
    private String conCertificateType;
    @XmlElement(name = "con_certificate_no")
    private String conCertificateNo;
    @XmlElement(name = "con_juristic")
    private String conJurisitc;
    @XmlElement(name = "con_telephone")
    private String conTelephone;
    @XmlElement(name = "con_locus")
    private String conLocus;
    @XmlElement(name = "con_postalcode")
    private String conPostalcode;
    @XmlElement(name = "con_fincal_org")
    private String conFincalOrg;
    @XmlElement(name = "con_account_no")
    private String conAccountNo;
    @XmlElement(name = "ass_customer_name")
    private String assCustomerName;
    @XmlElement(name = "ass_juristic")
    private String assJuristic;
    @XmlElement(name = "ass_telephone")
    private String assTelephone;
    @XmlElement(name = "ass_locus")
    private String assLocus;
    @XmlElement(name = "ass_postalcode")
    private String assPostalcode;
    @XmlElement(name = "con_fee")
    private BigDecimal conFee;
    @XmlElement(name = "co_customer_info")
    private List<CoCustomerInfo> coCustomerInfoList;
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

    public String getLoanCate() {
        return loanCate;
    }

    public void setLoanCate(String loanCate) {
        this.loanCate = loanCate;
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

    public BigDecimal getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(BigDecimal outstanding) {
        this.outstanding = outstanding;
    }

    public String getGuarType() {
        return guarType;
    }

    public void setGuarType(String guarType) {
        this.guarType = guarType;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getIsRealQuotaLoan() {
        return isRealQuotaLoan;
    }

    public void setIsRealQuotaLoan(String isRealQuotaLoan) {
        this.isRealQuotaLoan = isRealQuotaLoan;
    }

    public String getRealQuotaNo() {
        return realQuotaNo;
    }

    public void setRealQuotaNo(String realQuotaNo) {
        this.realQuotaNo = realQuotaNo;
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

    public String getDisputeScheme() {
        return disputeScheme;
    }

    public void setDisputeScheme(String disputeScheme) {
        this.disputeScheme = disputeScheme;
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

    public String getConJurisitc() {
        return conJurisitc;
    }

    public void setConJurisitc(String conJurisitc) {
        this.conJurisitc = conJurisitc;
    }

    public String getConTelephone() {
        return conTelephone;
    }

    public void setConTelephone(String conTelephone) {
        this.conTelephone = conTelephone;
    }

    public String getConLocus() {
        return conLocus;
    }

    public void setConLocus(String conLocus) {
        this.conLocus = conLocus;
    }

    public String getConPostalcode() {
        return conPostalcode;
    }

    public void setConPostalcode(String conPostalcode) {
        this.conPostalcode = conPostalcode;
    }

    public String getConFincalOrg() {
        return conFincalOrg;
    }

    public void setConFincalOrg(String conFincalOrg) {
        this.conFincalOrg = conFincalOrg;
    }

    public String getConAccountNo() {
        return conAccountNo;
    }

    public void setConAccountNo(String conAccountNo) {
        this.conAccountNo = conAccountNo;
    }

    public String getAssCustomerName() {
        return assCustomerName;
    }

    public void setAssCustomerName(String assCustomerName) {
        this.assCustomerName = assCustomerName;
    }

    public String getAssJuristic() {
        return assJuristic;
    }

    public void setAssJuristic(String assJuristic) {
        this.assJuristic = assJuristic;
    }

    public String getAssTelephone() {
        return assTelephone;
    }

    public void setAssTelephone(String assTelephone) {
        this.assTelephone = assTelephone;
    }

    public String getAssLocus() {
        return assLocus;
    }

    public void setAssLocus(String assLocus) {
        this.assLocus = assLocus;
    }

    public String getAssPostalcode() {
        return assPostalcode;
    }

    public void setAssPostalcode(String assPostalcode) {
        this.assPostalcode = assPostalcode;
    }

    public BigDecimal getConFee() {
        return conFee;
    }

    public void setConFee(BigDecimal conFee) {
        this.conFee = conFee;
    }

    public List<CoCustomerInfo> getCoCustomerInfoList() {
        return coCustomerInfoList;
    }

    public void setCoCustomerInfoList(List<CoCustomerInfo> coCustomerInfoList) {
        this.coCustomerInfoList = coCustomerInfoList;
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
        return "ContractInfo{" +
                "reportType='" + reportType + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", contractNo='" + contractNo + '\'' +
                ", loanCate='" + loanCate + '\'' +
                ", contractName='" + contractName + '\'' +
                ", customerType='" + customerType + '\'' +
                ", customerName='" + customerName + '\'' +
                ", certificateType='" + certificateType + '\'' +
                ", certificateNo='" + certificateNo + '\'' +
                ", linkman='" + linkman + '\'' +
                ", telephone='" + telephone + '\'' +
                ", loanObject='" + loanObject + '\'' +
                ", loanObjectSize='" + loanObjectSize + '\'' +
                ", contractSignDate='" + contractSignDate + '\'' +
                ", contractBeginDate='" + contractBeginDate + '\'' +
                ", contractEndDate='" + contractEndDate + '\'' +
                ", contractAmount=" + contractAmount +
                ", outstanding=" + outstanding +
                ", guarType='" + guarType + '\'' +
                ", ccy='" + ccy + '\'' +
                ", isRealQuotaLoan='" + isRealQuotaLoan + '\'' +
                ", realQuotaNo='" + realQuotaNo + '\'' +
                ", intRate=" + intRate +
                ", priPltyRate=" + priPltyRate +
                ", contractStatus='" + contractStatus + '\'' +
                ", relationManager='" + relationManager + '\'' +
                ", disputeScheme='" + disputeScheme + '\'' +
                ", conCustomerType='" + conCustomerType + '\'' +
                ", conCustomerName='" + conCustomerName + '\'' +
                ", conCertificateType='" + conCertificateType + '\'' +
                ", conCertificateNo='" + conCertificateNo + '\'' +
                ", conJurisitc='" + conJurisitc + '\'' +
                ", conTelephone='" + conTelephone + '\'' +
                ", conLocus='" + conLocus + '\'' +
                ", conPostalcode='" + conPostalcode + '\'' +
                ", conFincalOrg='" + conFincalOrg + '\'' +
                ", conAccountNo='" + conAccountNo + '\'' +
                ", assCustomerName='" + assCustomerName + '\'' +
                ", assJuristic='" + assJuristic + '\'' +
                ", assTelephone='" + assTelephone + '\'' +
                ", assLocus='" + assLocus + '\'' +
                ", assPostalcode='" + assPostalcode + '\'' +
                ", conFee=" + conFee +
                ", coCustomerInfoList=" + coCustomerInfoList +
                ", remark='" + remark + '\'' +
                ", reservedField1='" + reservedField1 + '\'' +
                ", reservedField2='" + reservedField2 + '\'' +
                ", reservedField3='" + reservedField3 + '\'' +
                '}';
    }
}
