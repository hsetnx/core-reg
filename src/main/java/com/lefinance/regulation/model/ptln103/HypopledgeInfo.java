package com.lefinance.regulation.model.ptln103;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: jingyan
 * @Time: 2017/6/29 16:00
 * @Describe: 抵押质押报文实体类
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class HypopledgeInfo {
    @XmlElement(name = "guar_contract_no")
    private String guarContractNo;
    @XmlElement(name = "warrant_no")
    private String warrantNo;
    @XmlElement(name = "hypopledge_amount")
    private BigDecimal hypopledgeAmount;
    @XmlElement(name = "is_write_off")
    private String isWriteOff;
    @XmlElement(name = "write_off_date")
    private Date writeOffDate;


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

    @Override
    public String toString() {
        return "HypopledgeInfo{" +
                "guarContractNo='" + guarContractNo + '\'' +
                ", warrantNo='" + warrantNo + '\'' +
                ", hypopledgeAmount=" + hypopledgeAmount +
                ", isWriteOff='" + isWriteOff + '\'' +
                ", writeOffDate=" + writeOffDate +
                '}';
    }
}
