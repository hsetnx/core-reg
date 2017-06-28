package com.lefinance.regulation.model.ptln101;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by chenyong6 on 2017/4/26.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "batchNo",
        "dataType",
        "recordCount",
        "quotaInfoList"
})
public class PTLN101RequestBodyEntity {
    @XmlElement(name = "batch_no")
    private String batchNo;
    @XmlElement(name = "data_type")
    private String dataType;
    @XmlElement(name = "record_count")
    private int recordCount;

    @XmlElement(name = "quota_info")
    private List<QuotaInfo> quotaInfoList;


    public PTLN101RequestBodyEntity(){}
    public PTLN101RequestBodyEntity(String batchNo, String dataType, int recordCount, List<QuotaInfo> quotaInfoList){
        this.batchNo = batchNo;
        this.dataType = dataType;
        this.recordCount = recordCount;
        this.quotaInfoList = quotaInfoList;
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

    public List<QuotaInfo> getQuotaInfoList() {
        return quotaInfoList;
    }

    public void setQuotaInfoList(List<QuotaInfo> quotaInfoList) {
        this.quotaInfoList = quotaInfoList;
    }

    @Override
    public String toString() {
        return "PTLN101RequestBodyEntity{" +
                "batchNo='" + batchNo + '\'' +
                ", dataType='" + dataType + '\'' +
                ", recordCount=" + recordCount +
                ", quotaInfoList=" + quotaInfoList +
                '}';
    }
}
