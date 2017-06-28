package com.lefinance.regulation.model.xml;


import com.lefinance.regulation.model.ptln101.PTLN101RequestBodyEntity;
import com.lefinance.regulation.model.ptln102.PTLN102RequestBodyEntity;
import com.lefinance.regulation.model.ptln103.PTLN103RequestBodyEntity;
import com.lefinance.regulation.model.ptln104.PTLN104RequestBodyEntity;
import com.lefinance.regulation.model.ptln105.PTLN105RequestBodyEntity;
import com.lefinance.regulation.model.ptln106.PTLN106RequestBodyEntity;
import com.lefinance.regulation.model.ptln107.PTLN107RequestBodyEntity;
import com.lefinance.regulation.model.ptln199.PTLN199RequestBodyEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by chenyong6 on 2017/4/20.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "ptln101RequestBodyEntity",
        "ptln102RequestBodyEntity",
        "ptln103RequestBodyEntity",
        "ptln104RequestBodyEntity",
        "ptln105RequestBodyEntity",
        "ptln106RequestBodyEntity",
        "ptln107RequestBodyEntity",
        "ptln199RequestBodyEntity"
})
public class XmlRequestBody {
    @XmlElement(name = "gettx")
    private PTLN101RequestBodyEntity ptln101RequestBodyEntity;
    @XmlElement(name = "gettx")
    private PTLN102RequestBodyEntity ptln102RequestBodyEntity;
    @XmlElement(name = "gettx")
    private PTLN103RequestBodyEntity ptln103RequestBodyEntity;
    @XmlElement(name = "gettx")
    private PTLN104RequestBodyEntity ptln104RequestBodyEntity;
    @XmlElement(name = "gettx")
    private PTLN105RequestBodyEntity ptln105RequestBodyEntity;
    @XmlElement(name = "gettx")
    private PTLN106RequestBodyEntity ptln106RequestBodyEntity;
    @XmlElement(name = "gettx")
    private PTLN107RequestBodyEntity ptln107RequestBodyEntity;
    @XmlElement(name="GetTx")
    private PTLN199RequestBodyEntity ptln199RequestBodyEntity;


    @Override
    public String toString() {
        return "XmlRequestBody{" +
                "ptln101RequestBodyEntity=" + ptln101RequestBodyEntity +
                ", ptln102RequestBodyEntity=" + ptln102RequestBodyEntity +
                ", ptln103RequestBodyEntity=" + ptln103RequestBodyEntity +
                ", ptln104RequestBodyEntity=" + ptln104RequestBodyEntity +
                ", ptln105RequestBodyEntity=" + ptln105RequestBodyEntity +
                ", ptln106RequestBodyEntity=" + ptln106RequestBodyEntity +
                ", ptln107RequestBodyEntity=" + ptln107RequestBodyEntity +
                ", ptln199RequestBodyEntity=" + ptln199RequestBodyEntity +
                '}';
    }

    public PTLN101RequestBodyEntity getPtln101RequestBodyEntity() {
        return ptln101RequestBodyEntity;
    }

    public void setPtln101RequestBodyEntity(PTLN101RequestBodyEntity ptln101RequestBodyEntity) {
        this.ptln101RequestBodyEntity = ptln101RequestBodyEntity;
    }

    public PTLN102RequestBodyEntity getPtln102RequestBodyEntity() {
        return ptln102RequestBodyEntity;
    }

    public void setPtln102RequestBodyEntity(PTLN102RequestBodyEntity ptln102RequestBodyEntity) {
        this.ptln102RequestBodyEntity = ptln102RequestBodyEntity;
    }

    public PTLN103RequestBodyEntity getPtln103RequestBodyEntity() {
        return ptln103RequestBodyEntity;
    }

    public void setPtln103RequestBodyEntity(PTLN103RequestBodyEntity ptln103RequestBodyEntity) {
        this.ptln103RequestBodyEntity = ptln103RequestBodyEntity;
    }

    public PTLN104RequestBodyEntity getPtln104RequestBodyEntity() {
        return ptln104RequestBodyEntity;
    }

    public void setPtln104RequestBodyEntity(PTLN104RequestBodyEntity ptln104RequestBodyEntity) {
        this.ptln104RequestBodyEntity = ptln104RequestBodyEntity;
    }

    public PTLN105RequestBodyEntity getPtln105RequestBodyEntity() {
        return ptln105RequestBodyEntity;
    }

    public void setPtln105RequestBodyEntity(PTLN105RequestBodyEntity ptln105RequestBodyEntity) {
        this.ptln105RequestBodyEntity = ptln105RequestBodyEntity;
    }

    public PTLN106RequestBodyEntity getPtln106RequestBodyEntity() {
        return ptln106RequestBodyEntity;
    }

    public void setPtln106RequestBodyEntity(PTLN106RequestBodyEntity ptln106RequestBodyEntity) {
        this.ptln106RequestBodyEntity = ptln106RequestBodyEntity;
    }

    public PTLN107RequestBodyEntity getPtln107RequestBodyEntity() {
        return ptln107RequestBodyEntity;
    }

    public void setPtln107RequestBodyEntity(PTLN107RequestBodyEntity ptln107RequestBodyEntity) {
        this.ptln107RequestBodyEntity = ptln107RequestBodyEntity;
    }

    public PTLN199RequestBodyEntity getPtln199RequestBodyEntity() {
        return ptln199RequestBodyEntity;
    }

    public void setPtln199RequestBodyEntity(PTLN199RequestBodyEntity ptln199RequestBodyEntity) {
        this.ptln199RequestBodyEntity = ptln199RequestBodyEntity;
    }
}
