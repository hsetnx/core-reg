package com.lefinance.regulation.model.xml;


import com.lefinance.regulation.model.ptln101.QuotaInfo;
import com.lefinance.regulation.model.ptln102.ContractInfo;
import com.lefinance.regulation.model.ptln103.IssueInfo;
import com.lefinance.regulation.model.ptln104.RepayInfo;
import com.lefinance.regulation.model.ptln105.PayplanInfo;
import com.lefinance.regulation.model.ptln106.AbnormalInfo;
import com.lefinance.regulation.model.ptln107.NetbookInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by chenyong6 on 2017/4/20.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "batchNo",
        "dataType",
        "recordCount",
        "quotaInfoList",
        "contractInfoList",
        "issueInfoList",
        "repayInfoList",
        "payplanInfoList",
        "abnormalInfoList",
        "netbookInfoList"
})
public class XmlRequestBodyEntity {
    @XmlElement(name = "batch_no")
    private String batchNo;
    @XmlElement(name = "data_type")
    private String dataType;
    @XmlElement(name = "record_count")
    private int recordCount;

    @XmlElement(name = "quota_info")
    private List<QuotaInfo> quotaInfoList;
    @XmlElement(name = "contract_info")
    private List<ContractInfo> contractInfoList;
    @XmlElement(name = "issue_info")
    private List<IssueInfo> issueInfoList;
    @XmlElement(name = "repay_info")
    private List<RepayInfo> repayInfoList;
    @XmlElement(name = "payplan_info")
    private List<PayplanInfo> payplanInfoList;
    @XmlElement(name = "abnormal_info")
    private List<AbnormalInfo> abnormalInfoList;
    @XmlElement(name = "netbook_info")
    private List<NetbookInfo> netbookInfoList;


    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public List<QuotaInfo> getQuotaInfoList() {
        return quotaInfoList;
    }

    public void setQuotaInfoList(List<QuotaInfo> quotaInfoList) {
        this.quotaInfoList = quotaInfoList;
    }

    public List<ContractInfo> getContractInfoList() {
        return contractInfoList;
    }

    public void setContractInfoList(List<ContractInfo> contractInfoList) {
        this.contractInfoList = contractInfoList;
    }

    public List<IssueInfo> getIssueInfoList() {
        return issueInfoList;
    }

    public void setIssueInfoList(List<IssueInfo> issueInfoList) {
        this.issueInfoList = issueInfoList;
    }

    public List<RepayInfo> getRepayInfoList() {
        return repayInfoList;
    }

    public void setRepayInfoList(List<RepayInfo> repayInfoList) {
        this.repayInfoList = repayInfoList;
    }

    public List<PayplanInfo> getPayplanInfoList() {
        return payplanInfoList;
    }

    public void setPayplanInfoList(List<PayplanInfo> payplanInfoList) {
        this.payplanInfoList = payplanInfoList;
    }

    public List<AbnormalInfo> getAbnormalInfoList() {
        return abnormalInfoList;
    }

    public void setAbnormalInfoList(List<AbnormalInfo> abnormalInfoList) {
        this.abnormalInfoList = abnormalInfoList;
    }

    public List<NetbookInfo> getNetbookInfoList() {
        return netbookInfoList;
    }

    public void setNetbookInfoList(List<NetbookInfo> netbookInfoList) {
        this.netbookInfoList = netbookInfoList;
    }

    @Override
    public String toString() {
        return "XmlRequestBodyEntity{" +
                "batchNo='" + batchNo + '\'' +
                ", dataType='" + dataType + '\'' +
                ", recordCount=" + recordCount +
                ", quotaInfoList=" + quotaInfoList +
                ", contractInfoList=" + contractInfoList +
                ", issueInfoList=" + issueInfoList +
                ", repayInfoList=" + repayInfoList +
                ", payplanInfoList=" + payplanInfoList +
                ", abnormalInfoList=" + abnormalInfoList +
                ", netbookInfoList=" + netbookInfoList +
                '}';
    }
}
