package com.lefinance.regulation.model.ptln199;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @Author: jingyan
 * @Time: 2017/6/29 16:03
 * @Describe: 查询
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "batchNo",
        "dataType"
})
public class PTLN199RequestBodyEntity {
    @XmlElement(name = "BATCH_NO")
    private String batchNo;
    @XmlElement(name = "DATA_TYPE")
    private String dataType;

    public PTLN199RequestBodyEntity(){}
    public PTLN199RequestBodyEntity(String batchNo, String dataType){
        this.batchNo = batchNo;
        this.dataType = dataType;
    }

    @Override
    public String toString() {
        return "PTLN199RequestBodyEntity{" +
                "batchNo='" + batchNo + '\'' +
                ", dataType='" + dataType + '\'' +
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
}
