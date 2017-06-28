package com.lefinance.config.datapush;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by chenyong6 on 2017/4/28.
 */
@Component
public class DataPushConfig {
    @Value("${local.branch.id}")
    private String localBranchId;
    @Value("${local.file.directory}")
    private String localFileDirectory;
    @Value("${local.file.batchSize}")
    private int localBatchSize;
    @Value("${regulator.ftp.ip}")
    private String ftpIp;
    @Value("${regulator.ftp.port}")
    private int ftpPort;
    @Value("${regulator.ftp.user}")
    private String ftpUser;
    @Value("${regulator.ftp.pswd}")
    private String ftpPswd;
    @Value("${regulator.ftp.file.directory}")
    private String ftpFileDirectory;
    @Value("${regulator.ftp.timeout}")
    private int ftpTimeout;
    @Value("${regulator.server.ip}")
    private String serverIp;
    @Value("${regulator.server.port}")
    private int serverPort;
    @Value("${regulator.retryNum}")
    private int retryNum;


    public String getLocalBranchId() {
        return localBranchId;
    }

    public void setLocalBranchId(String localBranchId) {
        this.localBranchId = localBranchId;
    }

    public String getLocalFileDirectory() {
        return localFileDirectory;
    }

    public void setLocalFileDirectory(String localFileDirectory) {
        this.localFileDirectory = localFileDirectory;
    }

    public int getLocalBatchSize() {
        return localBatchSize;
    }

    public void setLocalBatchSize(int localBatchSize) {
        this.localBatchSize = localBatchSize;
    }

    public String getFtpIp() {
        return ftpIp;
    }

    public void setFtpIp(String ftpIp) {
        this.ftpIp = ftpIp;
    }

    public int getFtpPort() {
        return ftpPort;
    }

    public void setFtpPort(int ftpPort) {
        this.ftpPort = ftpPort;
    }

    public String getFtpUser() {
        return ftpUser;
    }

    public void setFtpUser(String ftpUser) {
        this.ftpUser = ftpUser;
    }

    public String getFtpPswd() {
        return ftpPswd;
    }

    public void setFtpPswd(String ftpPswd) {
        this.ftpPswd = ftpPswd;
    }

    public String getFtpFileDirectory() {
        return ftpFileDirectory;
    }

    public void setFtpFileDirectory(String ftpFileDirectory) {
        this.ftpFileDirectory = ftpFileDirectory;
    }

    public int getFtpTimeout() {
        return ftpTimeout;
    }

    public void setFtpTimeout(int ftpTimeout) {
        this.ftpTimeout = ftpTimeout;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public int getRetryNum() {
        return retryNum;
    }

    public void setRetryNum(int retryNum) {
        this.retryNum = retryNum;
    }

    @Override
    public String toString() {
        return "DataPushConfig{" +
                "localBranchId='" + localBranchId + '\'' +
                ", localFileDirectory='" + localFileDirectory + '\'' +
                ", localBatchSize=" + localBatchSize +
                ", ftpIp='" + ftpIp + '\'' +
                ", ftpPort='" + ftpPort + '\'' +
                ", ftpUser='" + ftpUser + '\'' +
                ", ftpPswd='" + ftpPswd + '\'' +
                ", ftpFileDirectory='" + ftpFileDirectory + '\'' +
                ", ftpTimeout='" + ftpTimeout + '\'' +
                ", serverIp='" + serverIp + '\'' +
                ", serverPort='" + serverPort + '\'' +
                '}';
    }
}
