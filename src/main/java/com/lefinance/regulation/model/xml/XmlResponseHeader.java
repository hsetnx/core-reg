package com.lefinance.regulation.model.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by chenyong6 on 2017/4/20.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "headerEntity"
})
public class XmlResponseHeader {
    @XmlElement(name = "msg")
    private XmlResponseHeaderEntity headerEntity;

    public XmlResponseHeaderEntity getHeaderEntity() {
        return headerEntity;
    }

    public void setHeaderEntity(XmlResponseHeaderEntity headerEntity) {
        this.headerEntity = headerEntity;
    }

    @Override
    public String toString() {
        return "XmlResponseHeader{" +
                "headerEntity=" + headerEntity +
                '}';
    }
}
