package com.lefinance.common.utils.QRcode.vo;

import java.awt.*;

/**
 * @Author: Jingyan
 * @Time: 2017-11-10 11:21
 * @Description: 文字设置
 */
public class TextConfigVo {

    private String fontName="宋体";
    //字体样式
    private int fontStyle = Font.BOLD;
    //字体默认颜色
    private Color fontColor = Color.BLACK;
    //字号
    private int fontSize = 18;

    public int getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(int fontStyle) {
        this.fontStyle = fontStyle;
    }

    public Color getFontColor() {
        return fontColor;
    }

    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }
}