package com.lefinance.regulation.model;

/**
 * Created by chenyong6 on 2017/4/21.
 */
public class CommonResponse {
    private int code;
    private String message;
    private Object content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", content=" + content +
                '}';
    }
}
