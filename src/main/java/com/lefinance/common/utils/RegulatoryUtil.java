package com.lefinance.common.utils;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.lefinance.common.constant.TransEnum;
import com.lefinance.common.exception.CommonException;
import com.lefinance.common.exception.ErrorCode;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.Socket;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/**
 * Created by jingyan on 2017/4/28.
 */
public class RegulatoryUtil {

    private static Logger logger = LoggerFactory.getLogger(RegulatoryUtil.class);

    /**
     * 对象转换为XML字符串
     * @param obj
     * @param clazz
     * @return
     * @throws Exception
     */
    public static String objectToXmlStr(Object obj, Class<?> clazz) throws CommonException {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            // 根据上下文获取marshaller对象
            Marshaller marshaller = context.createMarshaller();
            // 设置编码字符集
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            // 格式化XML输出，有分行和缩进
            //marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            marshaller.marshal(obj, baos);
            return new String(baos.toByteArray(), "UTF-8").replace(" standalone=\"yes\"", "");
        } catch (Exception ex) {
            logger.error("objectToXmlStr: obj to xml err.", ex);
            throw new CommonException(ErrorCode.PUTFILE_OBJECTTOXML);
        }
    }

    /**
     * XML字符串转换为对象
     *
     * @param xmlStr
     * @param clazz
     * @param <T>
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static <T> T xmlStrToObject(String xmlStr, Class<T> clazz) throws CommonException {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(xmlStr));
        } catch (Exception ex) {
            logger.error("xmlStrToObject: xml to obj err.", ex);
            throw new CommonException(ErrorCode.PUTFILE_XMLTOOBJECT);
        }
    }

    /**
     * 创建本地文件
     *
     * @param filedir
     * @param filename
     * @param data
     * @throws CommonException
     */
    public static void createFileLocal(String filedir, String filename, String data) throws CommonException {
        File file = new File(filedir, filename);
        try {
            FileUtils.writeStringToFile(file, data, "utf-8");
        } catch (IOException ex) {
            logger.error("createFileLocal: write data to file err.", ex);
            throw new CommonException(ErrorCode.PUTFILE_XMLTOFILE);
        }
    }

    /**
     * 上传文件到ftp
     *
     * @param srcfile
     * @param dstfile
     * @param ip
     * @param port
     * @param username
     * @param password
     * @param timeout
     * @throws CommonException
     */
    public static void pushFileToFtp(String srcfile, String dstfile, String ip, int port, String username, String password, int timeout) throws CommonException {
        logger.debug("pushFileToFtp: srcfile={}, dstfile={}, ip={}, port={}, username={}, password={}, timeout={}", srcfile, dstfile, ip, port, username, password, timeout);
        File file = new File(srcfile);
        if (!file.exists()) {
            logger.error("pushFileToFtp: file not exists.");
            throw new CommonException(ErrorCode.PUTFILE_FILE_NOT_EXISTS);
        }

        Session session = null;
        Channel channel = null;
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(username, ip, port);
            if (password != null) {
                session.setPassword(password); // 设置密码
            }
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);//为session对象设置properties
            session.setTimeout(timeout);//设置超时时间
            session.connect(); //通过session建立链接
            channel = session.openChannel("sftp");//打开SFTP通道
            channel.connect();
            ChannelSftp csftp = (ChannelSftp) channel;
            csftp.put(srcfile, dstfile);
            logger.info("pushFileToFtp: push file success.");
        } catch (Exception ex) {
            logger.error("pushFileToFtp: push file failed.", ex);
            throw new CommonException(ErrorCode.PUTFILE_FTPERR);

        } finally {
            if (channel != null) channel.disconnect();
            if (session != null) session.disconnect();
        }
    }

    /**
     * 通过SOCKET发送XML请求
     *
     * @param requestXml
     * @param ip
     * @param port
     * @return
     * @throws CommonException
     */
    public static String sendBySocket(String requestXml, String ip, int port) throws CommonException {
        logger.debug("sendBySocket: requestXml={}", requestXml);
        if (!StringUtils.hasText(requestXml)) {
            logger.debug("sendBySocket: requestXml is null.");
            throw new CommonException(ErrorCode.SYS_PARAM_INVALID);
        }
        int requestMessageLength = 0;
        try {
            requestMessageLength = requestXml.getBytes("utf-8").length;
        } catch (UnsupportedEncodingException ex) {
            logger.error("sendBySocket: calculate request str len err.", ex);
            throw new CommonException(ErrorCode.PUTFILE_SOCKETERR);
        }
        String messageLengthHead = lpad(requestMessageLength + "", 8, "0");
        String requestXmlNew = messageLengthHead + requestXml;
        logger.debug("sendBySocket: requestXmlNew={}", requestXmlNew);

        String responseXml = "";
        Socket socket = null;
        OutputStream out = null;
        InputStream in = null;
        try {
            socket = new Socket(ip, port);
            out = socket.getOutputStream();
            in = socket.getInputStream();
            byte[] outputByte = requestXmlNew.getBytes("UTF-8");
            out.write(outputByte);
            out.flush();

            byte[] responseLengthHead = new byte[8];
            in.read(responseLengthHead);
            String m = new String(responseLengthHead);
            int responseMessagelenght = Integer.parseInt(m);
            logger.debug("sendBySocket: responseXml length={}", responseMessagelenght);
            byte[] responseMessageXml = new byte[responseMessagelenght];
            in.read(responseMessageXml);
            responseXml = new String(responseMessageXml, "utf-8");
            logger.info("sendBySocket: responseXml={}", responseXml);
            return responseXml;

        } catch (Exception ex) {
            logger.error("sendBySocket: send data to server by socket err.", ex);
            throw new CommonException(ErrorCode.PUTFILE_SOCKETERR);
        } finally {
            if (socket != null) {
                try {
                    if (in != null) in.close();
                } catch (Exception ex) {
                    logger.error("sendBySocket: socket close exception(in)", ex);
                    throw new CommonException(ErrorCode.SYS_SOCKET_CLOSE_EXCEPTION);
                }
                try {
                    if (null != null) out.close();
                } catch (Exception ex) {
                    logger.error("sendBySocket: socket close exception(out)", ex);
                    throw new CommonException(ErrorCode.SYS_SOCKET_CLOSE_EXCEPTION);
                }
                try {
                    socket.close();
                } catch (IOException ex) {
                    logger.error("sendBySocket: socket close exception", ex);
                    throw new CommonException(ErrorCode.SYS_SOCKET_CLOSE_EXCEPTION);
                }
            }
        }
    }

    /**
     * 计算下一次重试时间
     *
     * @param times
     * @param lastTime
     * @return
     */
    public static Date calcuNextTime(Integer times, Date lastTime) {
        int addTime = 0;
        if (times == null) {
            times = 0;
        }
        if (times.equals(0)) {
            addTime = 60;
        } else if (times.equals(1)) {
            addTime = 5 * 60;
        } else if (times.equals(2)) {
            addTime = 30 * 60;
        } else if (times.equals(3)) {
            addTime = 60 * 60;
        } else if (times.equals(4)) {
            addTime = 3 * 60 * 60;
        } else {
            addTime = times * 60 * 60;
        }
        if (lastTime == null) {
            lastTime = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lastTime);
        calendar.add(Calendar.SECOND, addTime);
        return calendar.getTime();
    }

    /**
     * 获取上传到重庆监管的的文件名称（组织机构代码-YYYYMMDD-数据类型-XX.xml）
     *
     * @param transEnum
     * @param branchId
     * @return
     */
    public static String getFilename(TransEnum transEnum, String branchId, String fileNo) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(branchId);
        stringBuffer.append("-");
        stringBuffer.append(PubMethod.getDateStr("yyyyMMdd"));
        stringBuffer.append("-");
        stringBuffer.append(transEnum.getDataType());
        stringBuffer.append("-");
        stringBuffer.append(fileNo);
        stringBuffer.append(".xml");
        return stringBuffer.toString();
    }

    /**
     * 组装8位头编码
     *
     * @param value
     * @param len
     * @param reg
     * @return
     */
    public static String lpad(String value, int len, String reg) {
        if (value == null) value = "";
        char[] valueArray = value.toCharArray();
        if (valueArray.length > len) {
            return value;
        }
        char[] returnArray = new char[len];
        char[] regArray = reg.toCharArray();
        int curLength = 0;
        while (curLength < len - valueArray.length) {
            System.arraycopy(regArray, 0, returnArray, curLength, regArray.length);
            curLength += regArray.length;
        }
        System.arraycopy(valueArray, 0, returnArray, len - valueArray.length, valueArray.length);
        return new String(returnArray);
    }
}
