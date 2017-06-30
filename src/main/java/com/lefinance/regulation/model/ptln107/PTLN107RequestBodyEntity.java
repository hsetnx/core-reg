package com.lefinance.regulation.model.ptln107;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * @Author: jingyan
 * @Time: 2017/6/29 16:03
 * @Describe: 报文头
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "batchNo",
        "dataType",
        "recordCount",
        "netbookInfoList"
})
public class PTLN107RequestBodyEntity {
    @XmlElement(name = "batch_no")
    private String batchNo;
    @XmlElement(name = "data_type")
    private String dataType;
    @XmlElement(name = "record_count")
    private int recordCount;

    @XmlElement(name = "netbook_info")
    private List<NetbookInfo> netbookInfoList;

    public PTLN107RequestBodyEntity(){}
    public PTLN107RequestBodyEntity(String batchNo, String dataType, int recordCount, List<NetbookInfo> netbookInfoList){
        this.batchNo = batchNo;
        this.dataType = dataType;
        this.recordCount = recordCount;
        this.netbookInfoList = netbookInfoList;
    }


    @Override
    public String toString() {
        return "PTLN107RequestBodyEntity{" +
                "batchNo='" + batchNo + '\'' +
                ", dataType='" + dataType + '\'' +
                ", recordCount=" + recordCount +
                ", netbookInfoList=" + netbookInfoList +
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

    public List<NetbookInfo> getNetbookInfoList() {
        return netbookInfoList;
    }

    public void setNetbookInfoList(List<NetbookInfo> netbookInfoList) {
        this.netbookInfoList = netbookInfoList;
    }
}
