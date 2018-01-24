package com.lefinance.regulation.service;

import com.lefinance.common.constant.RegulatoryContants;
import com.lefinance.common.constant.RetCodeEnum;
import com.lefinance.common.constant.TransEnum;
import com.lefinance.common.exception.CommonException;
import com.lefinance.common.exception.ErrorCode;
import com.lefinance.common.mq.producer.DefaultProducer;
import com.lefinance.common.utils.CommonUtil;
import com.lefinance.common.utils.PubMethod;
import com.lefinance.common.utils.RegulatoryUtil;
import com.lefinance.config.datapush.DataPushConfig;
import com.lefinance.regulation.dao.RegCqFileMapper;
import com.lefinance.regulation.domain.RegCqFile;
import com.lefinance.regulation.domain.RegCqFileLog;
import com.lefinance.regulation.model.ptln101.PTLN101RequestBodyEntity;
import com.lefinance.regulation.model.ptln102.PTLN102RequestBodyEntity;
import com.lefinance.regulation.model.ptln103.PTLN103RequestBodyEntity;
import com.lefinance.regulation.model.ptln104.PTLN104RequestBodyEntity;
import com.lefinance.regulation.model.ptln105.PTLN105RequestBodyEntity;
import com.lefinance.regulation.model.ptln106.PTLN106RequestBodyEntity;
import com.lefinance.regulation.model.ptln107.PTLN107RequestBodyEntity;
import com.lefinance.regulation.model.ptln199.PTLN199RequestBodyEntity;
import com.lefinance.regulation.model.xml.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jingyan
 * @Time: 2017/6/27 11:51
 * @Describe: 上报公共服务
 */
@Service
public abstract class DataPushBaseService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private RegCqFileMapper regCqFileMapper;
    @Resource
    protected DataPushConfig dataPushConfig;
    @Resource
    private RegCqFileService regCqFileService;
    @Resource
    private RegCqFileLogService regCqFileLogService;
    @Resource
    private DefaultProducer defaultProducer;


    /**
     * @Author: jingyan
     * @Time: 2017/6/27 17:54
     * @Describe: 上报监管入口
     */
    public boolean reportSupervise(TransEnum transEnum) {
        //1.锁定数据
        String batchGid = "";
        synchronized (transEnum) {
            batchGid = this.lockData();
        }
        if (PubMethod.isEmpty(batchGid)) {
            logger.info("上报监管入口---未查询到数据");
            return false;
        }
        //2.生成文件
        String filename = this.crearteFile(batchGid);
        if (PubMethod.isEmpty(filename)) {
            logger.info("上报监管入口---未生成文件");
            //解锁数据
            this.unlockData(batchGid, RegulatoryContants.DataStatus.UNREPORT);
            return false;
        }
        //3.上传文件
        boolean uploadFlag = this.uploadFile(batchGid);
        if (!uploadFlag) {
            logger.info("上报监管入口---文件上传失败");
            //解锁数据
            this.unlockData(batchGid, RegulatoryContants.DataStatus.UNREPORT);
            return false;
        }
        //4.通知文件
        boolean notifyFlag = this.notifyFile(transEnum, batchGid);
        if (!notifyFlag) {
            logger.info("上报监管入口---文件通知失败");
            //解锁数据
            this.unlockData(batchGid, RegulatoryContants.DataStatus.UNREPORT);
            return false;
        }
        return true;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/28 14:47
     * @Describe: 锁定数据
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public abstract String lockData();

    /**
     * @Author: jingyan
     * @Time: 2017/6/28 14:24
     * @Describe: 解锁数据
     */
    public abstract String unlockData(String batchGid, int status);

    /**
     * @Author: jingyan
     * @Time: 2017/6/27 17:51
     * @Describe: 生成文件
     */
    public abstract String crearteFile(String batchGid);

    /**
     * @Author: jingyan
     * @Time: 2017/6/28 15:29
     * @Describe: 查询结果入口
     */
    public boolean queryResult(String dataType) {
        RegCqFile record = new RegCqFile();
        record.setDataType(dataType);
        record.setStatus(RegulatoryContants.SendStatus.NOTIFIED);
        List<RegCqFile> list = regCqFileService.selectByDataTypeAndStatus(record);
        if (PubMethod.isEmpty(list)) {
            logger.info("查询结果入口---未查询到本地数据dataType={}", dataType);
            return false;
        }
        for (RegCqFile regCqFile : list) {
            this.queryReportResult(regCqFile.getGid());
        }
        return true;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/27 18:28
     * @Describe: 上传文件
     */
    public boolean uploadFile(String batchGid) {
        //查询数据库文件信息
        RegCqFile regCqFile = regCqFileService.selectByGid(batchGid);
        if (null == regCqFile || RegulatoryContants.SendStatus.DONE != regCqFile.getStatus()) {
            return false;
        }
        //上传文件
        try {
            String filepath = regCqFile.getFilepath() + File.separator + regCqFile.getFilename();
            this.pushFileToFtp(filepath);
            //更新文件表
            regCqFile.setStatus(RegulatoryContants.SendStatus.SENT);
            this.regCqFileService.updateByPrimaryKeySelective(regCqFile);
            //插入日志表
            this.regCqFileLogService.insert(batchGid, Boolean.TRUE, RegulatoryContants.LogRemark.PUSH_DATA);
            return true;
        } catch (Exception e) {
            //更新文件表
            regCqFile.setStatus(RegulatoryContants.SendStatus.DONE);
            regCqFile.setNextTime(RegulatoryUtil.calcuNextTime(regCqFile.getRetryNum(), regCqFile.getNextTime()));
            regCqFile.setReturnDesc(e.getMessage());
            regCqFile.setReturnData(e.getCause() == null ? "" : e.getCause().toString());
            this.regCqFileService.updateByPrimaryKeySelective(regCqFile);
            //插入日志表
            this.regCqFileLogService.insert(batchGid, Boolean.FALSE, RegulatoryContants.LogRemark.PUSH_DATA);
        }
        return false;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/27 17:51
     * @Describe: 上传后通知
     */
    public boolean notifyFile(TransEnum transEnum, String batchGid) {
        logger.info("文件上传通知接口---transEnum={}, batchGid={}", transEnum, batchGid);
        //查询数据库文件信息
        RegCqFile regCqFile = regCqFileService.selectByGid(batchGid);
        if (null == regCqFile || RegulatoryContants.SendStatus.SENT != regCqFile.getStatus()) {
            logger.error("文件上传通知接口---未查询到数据 batchGid={}", batchGid);
            return false;
        }
        String sqlNo = CommonUtil.get16RandCode();
        XmlRequestHeader header = this.buildRequestHeader(transEnum, regCqFile.getFilename(), sqlNo);
        logger.info("文件上传通知接口---header={}", header);
        XmlRequest request = new XmlRequest(header);
        //通过socket推送消息
        XmlResponse response = this.pushMessageBySocket(request);
        //处理推送结果
        if (null == response || null == response.getHeader() || null == response.getHeader().getHeaderEntity()
                || null == response.getHeader().getHeaderEntity().getRet()) {
            logger.info("文件上传通知接口---返回响应不合法");
            this.regCqFileLogService.insert(batchGid, Boolean.FALSE, RegulatoryContants.LogRemark.PUSH_MSG_NO_RESPONSE);
            return false;
        }
        //response header code
        String retStatus = response.getHeader().getHeaderEntity().getRetStatus();
        String retCode = "";
        String retMsg = "";
        XmlResponseHeaderEntity.RET ret = response.getHeader().getHeaderEntity().getRet();
        if (null != ret) {
            retCode = ret.getRetCode();
            retMsg = ret.getRetMsg();
        }
        //response body code
        String transRetCode = "";
        String transRetMsg = "";
        if (null != response.getBody() && null != response.getBody().getGetTx()) {
            transRetCode = response.getBody().getGetTx().getSysErrorcode();
            transRetMsg = RegulatoryContants.TransRetCodeMap.get(transRetCode);
        }
        //更新文件表
        regCqFile.setReturnCode(retCode);
        regCqFile.setReturnDesc(retMsg);
        regCqFile.setReturnData(response.toString());
        regCqFile.setTransReturnCode(transRetCode);
        regCqFile.setTransReturnDesc(transRetMsg);
        //插入记录表
        RegCqFileLog regCqFileLog = new RegCqFileLog();
        regCqFileLog.setSendData(request.toString());
        regCqFileLog.setReturnData(response.toString());
        regCqFileLog.setBatchGid(batchGid);
        regCqFileLog.setSeqNo(sqlNo);
        regCqFileLog.setRemark(RegulatoryContants.LogRemark.PUSH_FILE_AND_MSG);
        regCqFileLog.setReturnCode(regCqFile.getReturnCode());
        regCqFileLog.setReturnDesc(regCqFile.getReturnDesc());
        regCqFileLog.setReturnData(regCqFile.getReturnData());
        regCqFileLog.setTransReturnCode(regCqFile.getTransReturnCode());
        regCqFileLog.setTransReturnDesc(regCqFile.getTransReturnDesc());
        if (RegulatoryContants.RetStatus.SUCC.equals(retStatus) && RetCodeEnum.SUCC.getCode().equals(retCode)) {
            regCqFileLog.setIsSuccess(Boolean.TRUE);
            regCqFile.setStatus(RegulatoryContants.SendStatus.NOTIFIED);
            this.regCqFileService.updateByPrimaryKeySelective(regCqFile);
            this.regCqFileLogService.insert(regCqFileLog);
            return true;
        } else {
            regCqFileLog.setIsSuccess(Boolean.FALSE);
            regCqFile.setStatus(RegulatoryContants.SendStatus.SENT);
            this.regCqFileService.updateByPrimaryKeySelective(regCqFile);
            this.regCqFileLogService.insert(regCqFileLog);
            return false;
        }
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/28 15:11
     * @Describe: 查询上报结果
     */
    public String queryReportResult(String batchGid) {
        RegCqFile regCqFile = this.regCqFileService.selectByGid(batchGid);
        if (null == regCqFile) {
            logger.info("查询上报结果---未查询到本地数据,batchGid={}:" + batchGid);
            return null;
        }
        String sqlNo = CommonUtil.get16RandCode();
        XmlRequestHeader header = this.buildRequestHeader(TransEnum.PTLN199, regCqFile.getFilename(), sqlNo);
        logger.info("查询上报结果---header={}", header);
        XmlRequestBody body = this.buildRequestBody(new ArrayList(), TransEnum.PTLN199, batchGid);
        logger.info("查询上报结果---body={}", body);
        XmlRequest request = new XmlRequest(header, body);
        XmlResponse response = this.pushMessageBySocket(request);
        //处理推送结果
        if (null == response || null == response.getHeader() || null == response.getHeader().getHeaderEntity()
                || null == response.getHeader().getHeaderEntity().getRet()) {
            logger.info("查询上报结果---返回响应不合法");
            this.regCqFileLogService.insert(batchGid, Boolean.FALSE, RegulatoryContants.LogRemark.QUERY_RESULT);
            return null;
        }
        //response header code
        String retStatus = response.getHeader().getHeaderEntity().getRetStatus();
        String retCode = "";
        String retMsg = "";
        XmlResponseHeaderEntity.RET ret = response.getHeader().getHeaderEntity().getRet();
        if (null != ret) {
            retCode = ret.getRetCode();
            retMsg = ret.getRetMsg();
        }
        //response body code
        String transRetCode = "";
        String transRetMsg = "";
        if (null != response.getBody() && null != response.getBody().getGetTx()) {
            transRetCode = response.getBody().getGetTx().getSysErrorcode();
            transRetMsg = RegulatoryContants.TransRetCodeMap.get(transRetCode);
        }
        //更新文件表
        regCqFile.setReturnCode(retCode);
        regCqFile.setReturnDesc(retMsg);
        regCqFile.setReturnData(response.toString());
        regCqFile.setTransReturnCode(transRetCode);
        regCqFile.setTransReturnDesc(transRetMsg);
        //插入记录表
        RegCqFileLog regCqFileLog = new RegCqFileLog();
        regCqFileLog.setSendData(request.toString());
        regCqFileLog.setReturnData(response.toString());
        regCqFileLog.setBatchGid(batchGid);
        regCqFileLog.setSeqNo(sqlNo);
        regCqFileLog.setRemark(RegulatoryContants.LogRemark.QUERY_RESULT);
        regCqFileLog.setReturnCode(regCqFile.getReturnCode());
        regCqFileLog.setReturnDesc(regCqFile.getReturnDesc());
        regCqFileLog.setReturnData(regCqFile.getReturnData());
        regCqFileLog.setTransReturnCode(regCqFile.getTransReturnCode());
        regCqFileLog.setTransReturnDesc(regCqFile.getTransReturnDesc());
        if (RegulatoryContants.RetStatus.SUCC.equals(retStatus) && RetCodeEnum.SUCC.getCode().equals(retCode)) {
            regCqFileLog.setIsSuccess(Boolean.TRUE);
            regCqFile.setStatus(RegulatoryContants.SendStatus.REPORT_SUCCESS);
            this.regCqFileService.updateByPrimaryKeySelective(regCqFile);
            this.regCqFileLogService.insert(regCqFileLog);
            //修改业务数据状态
            this.unlockData(batchGid, RegulatoryContants.DataStatus.REPORTED);
            return batchGid;
        } else {
            regCqFileLog.setIsSuccess(Boolean.FALSE);
            regCqFile.setStatus(RegulatoryContants.SendStatus.REPORT_FAIL);
            this.regCqFileService.updateByPrimaryKeySelective(regCqFile);
            this.regCqFileLogService.insert(regCqFileLog);
            //修改业务数据状态
            this.unlockData(batchGid, RegulatoryContants.DataStatus.UNREPORT);
            return null;
        }
    }


    /**
     * @Author: jingyan
     * @Time: 2017/6/27 11:53
     * @Describe: 创建XML文件
     */
    public String createLocalFile(List businessData, TransEnum transEnum, String batchNo, String fileNo) {
        logger.info("createLocalFile: batchNo={}, fileNo={}, transEnum={}, data={}", batchNo, fileNo, transEnum, businessData);
        if (PubMethod.isEmpty(batchNo) || PubMethod.isEmpty(fileNo)) {
            logger.error("创建文件参数为空...");
            return null;
        }
        //创建文件对象
        XmlRequest xmlRequest = new XmlRequest(this.buildRequestBody(businessData, transEnum, batchNo));
        //对象转为字符串
        String xmlStr = RegulatoryUtil.objectToXmlStr(xmlRequest, XmlRequest.class);
        //生成文件名
        String filename = RegulatoryUtil.getFilename(transEnum, dataPushConfig.getLocalBranchId(), fileNo);
        //创建文件对象
        File file = new File(dataPushConfig.getLocalFileDirectory(), filename);
        if (file.exists()) {
            logger.error("文件已存在：" + filename);
            throw new CommonException(ErrorCode.PUTFILE_FILE_ALREADY_EXISTS);
        }
        //写入文件
        RegulatoryUtil.createFileLocal(dataPushConfig.getLocalFileDirectory(), filename, xmlStr);
        return filename;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/27 14:26
     * @Describe: 创建 {XML-BODY} 对象
     */
    private XmlRequestBody buildRequestBody(List data, TransEnum transEnum, String batchNo) {
        logger.debug("创建XML BODY 参数: start. batchNo={}, fileNo={}, transEnum={}, data={}", batchNo, transEnum, data);
        if (!StringUtils.hasText(batchNo) || null == data || null == transEnum) {
            logger.info("创建XML BODY 参数为空...");
            throw new CommonException(ErrorCode.SYS_PARAM_INVALID);
        }
        XmlRequestBody requestBody = new XmlRequestBody();
        if (TransEnum.PTLN101 == transEnum) {
            requestBody.setPtln101RequestBodyEntity(new PTLN101RequestBodyEntity(batchNo, transEnum.getDataType(), data.size(), data));
        } else if (TransEnum.PTLN102 == transEnum) {
            requestBody.setPtln102RequestBodyEntity(new PTLN102RequestBodyEntity(batchNo, transEnum.getDataType(), data.size(), data));
        } else if (TransEnum.PTLN103 == transEnum) {
            requestBody.setPtln103RequestBodyEntity(new PTLN103RequestBodyEntity(batchNo, transEnum.getDataType(), data.size(), data));
        } else if (TransEnum.PTLN104 == transEnum) {
            requestBody.setPtln104RequestBodyEntity(new PTLN104RequestBodyEntity(batchNo, transEnum.getDataType(), data.size(), data));
        } else if (TransEnum.PTLN105 == transEnum) {
            requestBody.setPtln105RequestBodyEntity(new PTLN105RequestBodyEntity(batchNo, transEnum.getDataType(), data.size(), data));
        } else if (TransEnum.PTLN106 == transEnum) {
            requestBody.setPtln106RequestBodyEntity(new PTLN106RequestBodyEntity(batchNo, transEnum.getDataType(), data.size(), data));
        } else if (TransEnum.PTLN107 == transEnum) {
            requestBody.setPtln107RequestBodyEntity(new PTLN107RequestBodyEntity(batchNo, transEnum.getDataType(), data.size(), data));
        } else if (TransEnum.PTLN199 == transEnum) {
            RegCqFile regCqFile = regCqFileMapper.selectByGid(batchNo);
            if (null == regCqFile) {
                throw new CommonException(ErrorCode.SYS_PARAM_INVALID);
            }
            requestBody.setPtln199RequestBodyEntity(new PTLN199RequestBodyEntity(batchNo, regCqFile.getDataType()));
        } else {
            logger.debug("事件类型未匹配到枚举...");
            throw new CommonException(ErrorCode.TRANS_CODE_NOT_SUPPORT);
        }
        return requestBody;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/27 18:19
     * @Describe: 上传文件到ftp
     */
    public void pushFileToFtp(String filepath) throws CommonException {
        logger.debug("文件上传开始: filepath={}", filepath);
        File file = new File(filepath);
        if (!file.exists()) {
            logger.error("需上传文件不存在: filepath={}", filepath);
            throw new CommonException(ErrorCode.PUTFILE_FILE_NOT_EXISTS);
        }
        RegulatoryUtil.pushFileToFtp(
                file.getAbsolutePath(),
                dataPushConfig.getFtpFileDirectory(),
                dataPushConfig.getFtpIp(),
                dataPushConfig.getFtpPort(),
                dataPushConfig.getFtpUser(),
                dataPushConfig.getFtpPswd(),
                dataPushConfig.getFtpTimeout());
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/27 19:09
     * @Describe: 通知接口组装报文
     */
    private XmlRequestHeader buildRequestHeader(TransEnum transEnum, String filePath, String seqNo) {
        XmlRequestHeaderEntity headerEntity = new XmlRequestHeaderEntity();
        headerEntity.setServiceCode(transEnum.getServiceCode());
        headerEntity.setTranCode(transEnum.getTransCode());
        headerEntity.setTranMode(transEnum.getTransMode());
        headerEntity.setBranchId(dataPushConfig.getLocalBranchId());
        headerEntity.setTranDate(PubMethod.getDateStr("yyyyMMdd"));
        headerEntity.setTranTimestamp(PubMethod.getDateStr("HHmmssSSS"));

        headerEntity.setUserLang("CHINESE");
        headerEntity.setSeqNo(seqNo);
        headerEntity.setModuleId("CL");
        if(TransEnum.PTLN199 != transEnum){
            headerEntity.setFilePath(filePath);
            headerEntity.setWsId(CommonUtil.getServerIP());
        }
        headerEntity.setMessageType(transEnum.getMsgType());
        headerEntity.setMessageCode(transEnum.getMsgCode());
        return new XmlRequestHeader(headerEntity);
    }

    /**
     * @Author: jingyan
     * @Time: 2017/6/28 10:55
     * @Describe: 通过socket推送数据
     */
    private XmlResponse pushMessageBySocket(XmlRequest xmlRequest) throws CommonException {
        if (null == xmlRequest) {
            logger.error("pushMessage: XmlRequest is null.");
            throw new CommonException(ErrorCode.SYS_PARAM_INVALID);
        }
        String requestXml = RegulatoryUtil.objectToXmlStr(xmlRequest, XmlRequest.class);
        logger.info("pushMessage: requestStr={}", requestXml);
        String responseXml = RegulatoryUtil.sendBySocket(requestXml, dataPushConfig.getServerIp(), dataPushConfig.getServerPort());
        logger.info("pushMessage: responseXml={}", responseXml);
        XmlResponse xmlResponse = RegulatoryUtil.xmlStrToObject(responseXml, XmlResponse.class);
        logger.info("pushMessage: xmlResponse={}", xmlResponse);
        return xmlResponse;
    }
}
