package com.lefinance.regulation.model.ptln103;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by chenyong6 on 2017/4/26.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PTLN103RequestBodyEntity {
    @XmlElement(name = "batch_no")
    private String batchNo;
    @XmlElement(name = "data_type")
    private String dataType;
    @XmlElement(name = "record_count")
    private int recordCount;
    @XmlElement(name = "issue_info")
    private List<IssueInfo> issueInfoList;



    public PTLN103RequestBodyEntity(){}
    public PTLN103RequestBodyEntity(String batchNo, String dataType, int recordCount, List<IssueInfo> issueInfoList){
        this.batchNo = batchNo;
        this.dataType = dataType;
        this.recordCount = recordCount;
        this.issueInfoList = issueInfoList;
    }

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

    public List<IssueInfo> getIssueInfoList() {
        return issueInfoList;
    }

    public void setIssueInfoList(List<IssueInfo> issueInfoList) {
        this.issueInfoList = issueInfoList;
    }

    @Override
    public String toString() {
        return "PTLN103RequestBodyEntity{" +
                "batchNo='" + batchNo + '\'' +
                ", dataType='" + dataType + '\'' +
                ", recordCount=" + recordCount +
                ", issueInfoList=" + issueInfoList +
                '}';
    }
}
