package com.lefinance.common.utils.QRcode.vo;

import java.awt.*;

/**
 * @Author: Jingyan
 * @Time: 2017-11-10 10:59
 * @Description: 二维码中间的logo
 */
public class LogoConfigVo {

    // logo默认边框宽度
    private int border = 2;
    // logo默认边框颜色
    private Color borderColor = Color.WHITE;
    // logo大小默认为照片的1/6
    private int logoPart = 6;

    public int getBorder() {
        return border;
    }

    public void setBorder(int border) {
        this.border = border;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getLogoPart() {
        return logoPart;
    }

    public void setLogoPart(int logoPart) {
        this.logoPart = logoPart;
    }
}