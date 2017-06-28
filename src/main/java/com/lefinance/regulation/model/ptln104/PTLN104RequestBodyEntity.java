package com.lefinance.regulation.model.ptln104;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by chenyong6 on 2017/4/26.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PTLN104RequestBodyEntity {
    @XmlElement(name = "batch_no")
    private String batchNo;
    @XmlElement(name = "data_type")
    private String dataType;
    @XmlElement(name = "record_count")
    private int recordCount;
    @XmlElement(name = "repay_info")
    private List<RepayInfo> repayInfoList;

    public PTLN104RequestBodyEntity(){}
    public PTLN104RequestBodyEntity(String batchNo, String dataType, int recordCount, List<RepayInfo> repayInfoList){
        this.batchNo = batchNo;
        this.dataType = dataType;
        this.recordCount = recordCount;
        this.repayInfoList = repayInfoList;
    }

    @Override
    public String toString() {
        return "PTLN104RequestBodyEntity{" +
                "batchNo='" + batchNo + '\'' +
                ", dataType='" + dataType + '\'' +
                ", recordCount=" + recordCount +
                ", repayInfoList=" + repayInfoList +
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

    public List<RepayInfo> getRepayInfoList() {
        return repayInfoList;
    }

    public void setRepayInfoList(List<RepayInfo> repayInfoList) {
        this.repayInfoList = repayInfoList;
    }
}
