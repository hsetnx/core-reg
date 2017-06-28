package com.lefinance.common.exception;

/**
 * Created by chenyong6 on 2017/4/18.
 */
public class CommonException extends RuntimeException{
    private int code;
    private String message;

    public CommonException(int code, String message){
        this.code = code;
        this.message = message;
    }

    public CommonException(ErrorCode errorCode){
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
