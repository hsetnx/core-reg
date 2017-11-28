package com.lefinance.common.utils.QRcode.vo;

import com.lefinance.common.utils.QRcode.enums.QRCreateType;

/**
 * @Author: Jingyan
 * @Time: 2017-11-10 14:03
 * @Description:
 */
public class QRInfoVo {

    private QRCreateType qrCreateType;
    //QR param
    private String filePath;
    private String fileName;
    private String qrContent;
    private int qrWidth;
    private int qrHeigh;
    //logo param
    private String logoFilePath;
    private LogoConfigVo logoConfigVo;
    //text param
    private String textContent;
    private TextConfigVo textConfigVo;

    @Override
    public String toString() {
        return "QRInfoVo{" +
                "qrCreateType=" + qrCreateType +
                ", filePath='" + filePath + '\'' +
                ", fileName='" + fileName + '\'' +
                ", qrContent='" + qrContent + '\'' +
                ", qrWidth=" + qrWidth +
                ", qrHeigh=" + qrHeigh +
                ", logoFilePath='" + logoFilePath + '\'' +
                ", logoConfigVo=" + logoConfigVo +
                ", textContent='" + textContent + '\'' +
                ", textConfigVo=" + textConfigVo +
                '}';
    }

    public QRCreateType getQrCreateType() {
        return qrCreateType;
    }

    public void setQrCreateType(QRCreateType qrCreateType) {
        this.qrCreateType = qrCreateType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getQrContent() {
        return qrContent;
    }

    public void setQrContent(String qrContent) {
        this.qrContent = qrContent;
    }

    public int getQrWidth() {
        return qrWidth;
    }

    public void setQrWidth(int qrWidth) {
        this.qrWidth = qrWidth;
    }

    public int getQrHeigh() {
        return qrHeigh;
    }

    public void setQrHeigh(int qrHeigh) {
        this.qrHeigh = qrHeigh;
    }

    public String getLogoFilePath() {
        return logoFilePath;
    }

    public void setLogoFilePath(String logoFilePath) {
        this.logoFilePath = logoFilePath;
    }

    public LogoConfigVo getLogoConfigVo() {
        return logoConfigVo;
    }

    public void setLogoConfigVo(LogoConfigVo logoConfigVo) {
        this.logoConfigVo = logoConfigVo;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public TextConfigVo getTextConfigVo() {
        return textConfigVo;
    }

    public void setTextConfigVo(TextConfigVo textConfigVo) {
        this.textConfigVo = textConfigVo;
    }
}