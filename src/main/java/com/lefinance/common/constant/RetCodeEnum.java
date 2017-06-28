package com.lefinance.common.constant;

/**
 * Created by chenyong6 on 2017/5/2.
 */
public enum RetCodeEnum {

    SUCC("000000", "交易成功"),
    FAIL("000001", "交易失败"),
    REPEAT("000002", "交易重复"),
    EXCEPTION("999999", "交易异常，需异常处理");

    private String code;
    private String msg;

    private RetCodeEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
