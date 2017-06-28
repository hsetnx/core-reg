package com.lefinance.regulation.model.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by chenyong6 on 2017/4/20.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlRequestHeader {
    @XmlElement(name = "msg")
    private XmlRequestHeaderEntity headerEntity;

    public XmlRequestHeader(){}
    public XmlRequestHeader(XmlRequestHeaderEntity headerEntity){
        this.headerEntity = headerEntity;
    }

    public XmlRequestHeaderEntity getHeaderEntity() {
        return headerEntity;
    }

    public void setHeaderEntity(XmlRequestHeaderEntity headerEntity) {
        this.headerEntity = headerEntity;
    }

    @Override
    public String toString() {
        return "XmlRequestHeader{" +
                "headerEntity=" + headerEntity +
                '}';
    }
}
