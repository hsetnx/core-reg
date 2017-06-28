package com.lefinance.regulation.domain;

import java.math.BigDecimal;
import java.util.Date;

public class RegCqIssueInfoHypoledgeInfo {
    private Integer id;

    private String issueInfoGid;

    private String guarContractNo;

    private String warrantNo;

    private BigDecimal hypopledgeAmount;

    private String isWriteOff;

    private Date writeOffDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIssueInfoGid() {
        return issueInfoGid;
    }

    public void setIssueInfoGid(String issueInfoGid) {
        this.issueInfoGid = issueInfoGid;
    }

    public String getGuarContractNo() {
        return guarContractNo;
    }

    public void setGuarContractNo(String guarContractNo) {
        this.guarContractNo = guarContractNo;
    }

    public String getWarrantNo() {
        return warrantNo;
    }

    public void setWarrantNo(String warrantNo) {
        this.warrantNo = warrantNo;
    }

    public BigDecimal getHypopledgeAmount() {
        return hypopledgeAmount;
    }

    public void setHypopledgeAmount(BigDecimal hypopledgeAmount) {
        this.hypopledgeAmount = hypopledgeAmount;
    }

    public String getIsWriteOff() {
        return isWriteOff;
    }

    public void setIsWriteOff(String isWriteOff) {
        this.isWriteOff = isWriteOff;
    }

    public Date getWriteOffDate() {
        return writeOffDate;
    }

    public void setWriteOffDate(Date writeOffDate) {
        this.writeOffDate = writeOffDate;
    }
}