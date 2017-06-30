package com.lefinance.regulation.model.ptln106;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * @Author: jingyan
 * @Time: 2017/6/29 15:59
 * @Describe: 报文头
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "batchNo",
        "dataType",
        "recordCount",
        "abnormalInfoList"
})
public class PTLN106RequestBodyEntity {
    @XmlElement(name = "batch_no")
    private String batchNo;
    @XmlElement(name = "data_type")
    private String dataType;
    @XmlElement(name = "record_count")
    private int recordCount;

    @XmlElement(name = "abnormal_info")
    private List<AbnormalInfo> abnormalInfoList;

    public PTLN106RequestBodyEntity(){}
    public PTLN106RequestBodyEntity(String batchNo, String dataType, int recordCount, List<AbnormalInfo> abnormalInfoList){
        this.batchNo = batchNo;
        this.dataType = dataType;
        this.recordCount = recordCount;
        this.abnormalInfoList = abnormalInfoList;
    }

    @Override
    public String toString() {
        return "PTLN106RequestBodyEntity{" +
                "batchNo='" + batchNo + '\'' +
                ", dataType='" + dataType + '\'' +
                ", recordCount=" + recordCount +
                ", abnormalInfoList=" + abnormalInfoList +
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

    public List<AbnormalInfo> getAbnormalInfoList() {
        return abnormalInfoList;
    }

    public void setAbnormalInfoList(List<AbnormalInfo> abnormalInfoList) {
        this.abnormalInfoList = abnormalInfoList;
    }
}
