package com.lefinance.regulation.model.xml;

import javax.xml.bind.annotation.*;

/**
 * Created by chenyong6 on 2017/4/20.
 */

@XmlRootElement(name = "transaction")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"header", "body"})
public class XmlRequest {
    @XmlElement(name = "header")
    private XmlRequestHeader header;
    @XmlElement(name = "body")
    private XmlRequestBody body;


    public XmlRequest(){}
    public XmlRequest(XmlRequestHeader header){
        this.header = header;
    }
    public XmlRequest(XmlRequestBody body){
        this.body = body;
    }
    public XmlRequest(XmlRequestHeader header, XmlRequestBody body){
        this.header = header;
        this.body = body;
    }


    public XmlRequestHeader getHeader() {
        return header;
    }

    public void setHeader(XmlRequestHeader header) {
        this.header = header;
    }

    public XmlRequestBody getBody() {
        return body;
    }

    public void setBody(XmlRequestBody body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "XmlRequest{" +
                "header=" + header +
                ", body=" + body +
                '}';
    }
}
