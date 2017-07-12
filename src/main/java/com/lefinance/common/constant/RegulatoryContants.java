package com.lefinance.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenyong6 on 2017/4/19.
 */
public class RegulatoryContants {


    public static Map<String, String> RetCodeMap = new HashMap<>();

    static {
        RetCodeMap.put("000000", "成功");
        RetCodeMap.put("000001", "交易失败");
        RetCodeMap.put("000002", "交易重复");
        RetCodeMap.put("999999", "交易异常，需异常处理");
    }


    public static Map<String, String> TransRetCodeMap = new HashMap<>();

    static {
        TransRetCodeMap.put("1907", "报文类型和报文代码没有匹配上");
        TransRetCodeMap.put("1708", "远程连接失败");
        TransRetCodeMap.put("1709", "EOD处理中，不允许进行数据上报操作");
        TransRetCodeMap.put("991201", "原文件不存在");
        TransRetCodeMap.put("991205", "XSD校验失败");
        TransRetCodeMap.put("991207", "批次号重复");
        TransRetCodeMap.put("000000", "成功");
        TransRetCodeMap.put("000001", "数据导入中");
        TransRetCodeMap.put("100000", "机构信息不存在");
        TransRetCodeMap.put("100001", "服务代码不存在");
        TransRetCodeMap.put("100002", "数据重复");
        TransRetCodeMap.put("010101", "额度信息对应客户信息更新失败");
        TransRetCodeMap.put("010102", "额度信息更新失败");
        TransRetCodeMap.put("010201", "贷款合同更新失败");
        TransRetCodeMap.put("010203", "额度不足");
        TransRetCodeMap.put("010301", "贷款发放更新失败");
        TransRetCodeMap.put("010302", "贷款合同信息未录入");
        TransRetCodeMap.put("010401", "贷款回收更新失败");
        TransRetCodeMap.put("010402", "贷款发放信息未录入");
        TransRetCodeMap.put("010501", "还款计划更新失败");
        TransRetCodeMap.put("010502", "贷款发放信息未录入");
        TransRetCodeMap.put("010601", "非正常客户信息更新失败");
    }


    public static class ReceiptType {
        public static final String NORMAL = "550001";//正常回款
        public static final String OVERDUE = "550002";//逾期回款
        public static final String ADVANCE = "550003";//提前回款
        public static final String BAD_VERIFICATION = "550004";//不良核销
        public static final String ASSET_TRANSFER = "550005";//资产转让
    }


    public static class GatherMode {
        public static final String BANK_WITHHOLD = "430001";//银行代扣
        public static final String UNIONPAY_WITHOLD = "430002";
        public static final String CASH = "430003";
        public static final String BANK_TRANSFER = "430004";//银行转账
        public static final String OTHER = "430005";
    }


    public static class Industry {
        public static final String AGRICULTURAL = "290001";
        public static final String INDUSTRIAL = "290002";
        public static final String CONSTRUCTION = "290003";//建筑业
        public static final String ESTATE = "290004";//房地产业
        public static final String COMMERCE = "290005";//商贸流通业
        public static final String TRANSPORTATION = "290006";
        public static final String WAREHOUSING = "290007";//仓储业
        public static final String ACCOMMODATION_AND_CATERING = "290008";//住宿和餐饮业
        public static final String OTHER = "290009";
        public static final String RURAL = "290010"; //农村
        public static final String FARMERS = "290011";//农民

    }

    public static class LoanObjectSize {
        public static final String LARGE = "280001";
        public static final String MEDIUM = "280007";
        public static final String SMALL = "280002";
        public static final String MICRO = "280004";
        public static final String INDIVIDUAL = "280005"; //个体工商户
        public static final String PERSONAL = "280003";//个人
        public static final String OTHER = "280006";

    }

    public static class RateCalcMode {
        public static final String SERVICING = "270001";//还本付息
        public static final String INSTALMENT = "270002";//分期付款
        public static final String INTEREST_INSTALMENT_AND_CAPITAL_ONCE = "270003"; //按期还息到期还本
        public static final String ADVANCE_INTEREST_AND_CAPITAL_ONCE = "270004"; //预收利息到期还本
        public static final String ADVANCE_INTEREST_AND_CAPITAL_INSTALLMENT = "270005"; //预收利息分期还本
        public static final String AVERAGE_CAPITAL_AND_INTEREST = "270006"; //等额本息
        public static final String AVERAGE_CAPITAL = "270007"; //等额本金
        public static final String FREE_REPAYMENT = "270008"; //自由还款
    }

    public static class LoanPurpose {
        public static final String PRODUCTION = "260001";
        public static final String CONSUMPTION = "260002";
    }

    public static class LoanTerm {
        public static final String LESS_THAN_1M = "25001";
        public static final String BETWEEN_1M_AND_3M = "250002";
        public static final String BETWEEN_3M_AND_6M = "250003";
        public static final String BETWEEN_6M_AND_12M = "250004";
        public static final String GREATER_THAN_12M = "250005";
    }

    public static class LogRemark {
        public static final String LOCK_DATA = "锁定数据批次并生成批次文件";
        public static final String PUSH_DATA = "推送批次文件到FTP";
        public static final String PUSH_MSG = "推送数据批次到达通知";
        public static final String PUSH_MSG_NO_RESPONSE = "推送数据批次到达通知,未获得有效响应";
        public static final String PUSH_FILE_AND_MSG = "推送数据批次文件并发送到达通知";
        public static final String QUERY_RESULT = "查询数据批次推送结果";
    }

    public static class RetStatus {
        public static final String SUCC = "S";
        public static final String FAIL = "F";
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/27 16:58
     * @Describe: 发送数据状态---一批一条记录
     */
    public static class SendStatus {
        public static final Integer READY = 1;
        public static final Integer DONE = 2;
        public static final Integer SENDING = 3;
        public static final Integer SENT = 4;
        public static final Integer NOTIFYING = 5;
        public static final Integer NOTIFIED = 6;
        public static final Integer RESULT_QUERYING = 7;
        public static final Integer REPORT_SUCCESS = 8;
        public static final Integer REPORT_FAIL = 9;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/28 11:23
     * @Describe: 数据状态
     */
    public static class DataStatus {
        //未上报
        public static final Integer UNREPORT = 1;
        //上报中
        public static final Integer REPORTING = 2;
        //上报成功
        public static final Integer REPORTED = 3;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/28 18:27
     * @Describe: 获取文件序列号，redis key
     */
    public static class FileSequence {
        public static final String REDIS_CACHE_FILE_102_SEQUENCE = "REDIS_CACHE_FILE_102_";
        public static final String REDIS_CACHE_FILE_103_SEQUENCE = "REDIS_CACHE_FILE_103_";
        public static final String REDIS_CACHE_FILE_104_SEQUENCE = "REDIS_CACHE_FILE_104_";
        public static final String REDIS_CACHE_FILE_105_SEQUENCE = "REDIS_CACHE_FILE_105_";
        public static final String REDIS_CACHE_FILE_106_SEQUENCE = "REDIS_CACHE_FILE_106_";
        public static final String REDIS_CACHE_FILE_107_SEQUENCE = "REDIS_CACHE_FILE_107_";
    }

    public static class TransCode {
        public static final String PTLN001 = "PTLN001";
        public static final String PTLN101 = "PTLN101";
        public static final String PTLN102 = "PTLN102";
        public static final String PTLN103 = "PTLN103";
        public static final String PTLN104 = "PTLN104";
        public static final String PTLN105 = "PTLN105";
        public static final String PTLN106 = "PTLN106";
        public static final String PTLN107 = "PTLN107";
        public static final String PTLN199 = "PTLN199";
    }

    public class DataType {
        public static final String QUOTA_INFO = "QUOTA_INFO";
        public static final String CONTRACT_INFO = "CONTRACT_INFO";
        public static final String ISSUE_INFO = "ISSUE_INFO";
        public static final String REPAY_INFO = "REPAY_INFO";
        public static final String PAYPLAN_INFO = "PAYPLAN_INFO";
        public static final String ABNORMAL_INFO = "ABNORMAL_INFO";
        public static final String NETBOOK_INFO = "NETBOOK_INFO";
    }


    public static class TransMode {
        public static final String ONLINE = "ONLINE";
        public static final String ASYNC = "ASYNC";
    }

    public static class ServiceCode {
        public static final String SVN_PTLN = "SVR_PTLN";
        public static final String SVR_FILE = "SVR_FILE";
    }

    public static class MessageType {
        public static final String TYPE_1200 = "1200";
        public static final String TYPE_1220 = "1220";
    }

    public static class MessageCode {
        public static final String CODE_0001 = "0001";
        public static final String CODE_0101 = "0101";
        public static final String CODE_0102 = "0102";
        public static final String CODE_0103 = "0103";
        public static final String CODE_0104 = "0104";
        public static final String CODE_0105 = "0105";
        public static final String CODE_0106 = "0106";
        public static final String CODE_0107 = "0107";
        public static final String CODE_0199 = "0199";


    }

    public static class ReportType {
        public static final String CREATE = "100001";
        public static final String UPDATE = "100002";
        public static final String DELETE = "100003";

    }

    public static class CustomerType {
        public static String PERSONAL = "480001";
        public static String ENTERPRISE = "480002";
    }

    public static class CertificateType {
        public static String ID_CARD = "150001";
        public static String ORG_CODE = "150002";
        public static String PASSPORT = "150003";
        public static String OTHER = "150004";
    }

    public static class CCY {
        public static String RMB = "730001";
    }

    public static class GuarType {
        public static String CREDIT = "240001";
        public static String MORTGAGE = "240002";
        public static String PLEDGE = "240003";
        public static String ENSURE = "240004";

    }

    public static class IsCircle {
        public static String YES = "740001";
        public static String NO = "740002";
    }

    public static class ContractStatus {
        public static String VALID = "490001";
        public static String INVALID = "490003";
        public static String TERMINATED = "490002";
    }


}
