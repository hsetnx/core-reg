package com.lefinance.common.constant;

/**
 * Created by chenyong6 on 2017/4/26.
 */
public enum  TransRetCodeEnum {

    CODE_1907("1907", "报文类型和报文代码没有匹配上"),
    CODE_1708("1708", "远程连接失败"),
    CODE_1709("1709", "EOD处理中，不允许进行数据上报操作"),
    CODE_991201("991201", "原文件不存在"),
    CODE_991205("991205", "XSD校验失败"),
    CODE_991207("991207", "批次号重复"),
    CODE_000000("000000", "成功"),
    CODE_000001("000001", "数据导入中"),
    CODE_100000("100000", "机构信息不存在"),
    CODE_100001("100001", "服务代码不存在"),
    CODE_100002("100002", "数据重复"),
    CODE_010101("010101", "额度信息对应客户信息更新失败"),
    CODE_010102("010102", "额度信息更新失败"),
    CODE_010201("010201", "贷款合同更新失败"),
    CODE_010203("010203", "额度不足"),
    CODE_010301("010301", "贷款发放更新失败"),
    CODE_010302("010302", "贷款合同信息未录入"),
    CODE_010401("010401", "贷款回收更新失败"),
    CODE_010402("010402", "贷款发放信息未录入"),
    CODE_010501("010501", "还款计划更新失败"),
    CODE_010502("010502", "贷款发放信息未录入"),
    CODE_010601("010601", "非正常客户信息更新失败");

    private String code;
    private String msg;

    private TransRetCodeEnum(String code, String msg){
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
