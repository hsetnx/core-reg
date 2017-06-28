package com.lefinance.regulation.model.ptln105;

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
        "payplanInfoList"
})
public class PTLN105RequestBodyEntity {
    @XmlElement(name = "batch_no")
    private String batchNo;
    @XmlElement(name = "data_type")
    private String dataType;
    @XmlElement(name = "record_count")
    private int recordCount;

    @XmlElement(name = "payplan_info")
    private List<PayplanInfo> payplanInfoList;

    public PTLN105RequestBodyEntity(){}
    public PTLN105RequestBodyEntity(String batchNo, String dataType, int recordCount, List<PayplanInfo> payplanInfoList){
        this.batchNo = batchNo;
        this.dataType = dataType;
        this.recordCount = recordCount;
        this.payplanInfoList = payplanInfoList;
    }

    @Override
    public String toString() {
        return "PTLN105RequestBodyEntity{" +
                "batchNo='" + batchNo + '\'' +
                ", dataType='" + dataType + '\'' +
                ", recordCount=" + recordCount +
                ", payplanInfoList=" + payplanInfoList +
                '}';
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

    public List<PayplanInfo> getPayplanInfoList() {
        return payplanInfoList;
    }

    public void setPayplanInfoList(List<PayplanInfo> payplanInfoList) {
        this.payplanInfoList = payplanInfoList;
    }
}
