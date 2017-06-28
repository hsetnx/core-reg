package com.lefinance.regulation.model.ptln102;

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
        "contractInfoList"
})
public class PTLN102RequestBodyEntity {
    @XmlElement(name = "batch_no")
    private String batchNo;
    @XmlElement(name = "data_type")
    private String dataType;
    @XmlElement(name = "record_count")
    private int recordCount;

    @XmlElement(name = "contract_info")
    private List<ContractInfo> contractInfoList;

    public PTLN102RequestBodyEntity(){}
    public PTLN102RequestBodyEntity(String batchNo, String dataType, int recordCount, List<ContractInfo> contractInfoList){
        this.batchNo = batchNo;
        this.dataType = dataType;
        this.recordCount = recordCount;
        this.contractInfoList = contractInfoList;
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

    public List<ContractInfo> getContractInfoList() {
        return contractInfoList;
    }

    public void setContractInfoList(List<ContractInfo> contractInfoList) {
        this.contractInfoList = contractInfoList;
    }

    @Override
    public String toString() {
        return "PTLN102RequestBodyEntity{" +
                "batchNo='" + batchNo + '\'' +
                ", dataType='" + dataType + '\'' +
                ", recordCount=" + recordCount +
                ", contractInfoList=" + contractInfoList +
                '}';
    }
}
