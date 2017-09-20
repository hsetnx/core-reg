package com.lefinance.common.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: jingyan
 * @Time: 2017/9/20 11:12
 * @Describe:
 */
public class CsvWriter {

    private FileChannel channel;
    private FileOutputStream fos;

    /**
     * @Author: jingyan
     * @Time: 2017/9/20 11:43
     * @Describe: 初始化写文件对象
     */
    public boolean initCsvWriter(String filePath, boolean appendable) {
        try {
            fos = new FileOutputStream(filePath, appendable);
            channel = fos.getChannel();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/9/20 11:42
     * @Describe: 关闭写文件流
     */
    public boolean closeCsvWriter() {
        try {
            if (null != channel) {
                channel.close();
            }
            if (null != fos) {
                fos.close();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/9/20 11:44
     * @Describe: 按行写入文件
     */
    public boolean writeFileByLine(String[] line) {
        try {
            String lineStr = PubMethod.arrayToString(line, ',')+"\r\n";
            channel.write(ByteBuffer.wrap(lineStr.getBytes()), channel.size());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public FileChannel getChannel() {
        return channel;
    }

    public void setChannel(FileChannel channel) {
        this.channel = channel;
    }
}
