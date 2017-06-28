package com.lefinance.regulation.model.xml;

import javax.xml.bind.annotation.*;

/**
 * Created by chenyong6 on 2017/4/20.
 */
@XmlRootElement(name = "transaction")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "header",
        "body"
})
public class XmlResponse {
    @XmlElement(name = "header")
    private XmlResponseHeader header;
    @XmlElement(name = "body")
    private XmlResponseBody body;

    public XmlResponseHeader getHeader() {
        return header;
    }

    public void setHeader(XmlResponseHeader header) {
        this.header = header;
    }

    public XmlResponseBody getBody() {
        return body;
    }

    public void setBody(XmlResponseBody body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "XmlResponse{" +
                "header=" + header +
                ", body=" + body +
                '}';
    }
}
