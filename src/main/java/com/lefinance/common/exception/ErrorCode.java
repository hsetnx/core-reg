package com.lefinance.common.exception;

/**
 * Created by chenyong6 on 2017/4/10.
 * <p>
 * Error Code Rules
 * <p>
 * - an integer (bigger than or equals to 0)
 * - range:
 * 0  succes, no error
 * 1 - 999: system errors or general errors
 * 1000 -  : other errors
 */
public enum ErrorCode {
    //////////////////////////////////////////
    // 0: success, no error
    /////////////////////////////////////////
    SUCCESS(0, "sys.succ"),





    //////////////////////////////////////////
    //1 - 999: system errors or general errors
    ///////////////////////////////////////////
    FAIL(1, "sys.fail"),
    SYS_TIMEOUT(2, "sys.fail.timeout"),
    SYS_TOKEN_INVALID(3, "sys.fail.token.invalid"),
    SYS_PARAM_INVALID(4, "sys.fail.param.invalid"),
    SYS_CHANNEL_INVALID(5, "sys.fail.channel.invalid"),
    SYS_REQUEST_TOO_FREQUENCE(6, "sys.fail.request.toofrequently"),
    SYS_SOCKET_CLOSE_EXCEPTION(7, "sys.fail.socket.close.err"),







    //////////////////////////////////////////
    //1 - inifinity other errors.
    //////////////////////////////////////////
    PUTFILE_OBJECTTOXML(1000, "对象转化为XML异常"),
    PUTFILE_XMLTOFILE(1001, "xml写入文件异常"),
    PUTFILE_FTPERR(1002, "上传文件到FTP异常"),
    PUTFILE_SOCKETERR(1003, "SOCKET消息发送异常"),
    PUTFILE_XMLTOOBJECT(1004, "XML转化为对象异常"),
    PUTFILE_FILE_ALREADY_EXISTS(1005, "该文件已经存在"),
    PUTFILE_FILE_NOT_EXISTS(1006, "该文件不存在"),
    TRANS_CODE_NOT_SUPPORT(1007, "交易编号不支持"),
    ;








    private int code;
    private String message;

    ErrorCode(int code, String message){
        this.code = code;
        this.message = message;
    }

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

    @Override
    public String toString() {
        return "ErrorCode{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
