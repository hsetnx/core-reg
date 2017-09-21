package com.lefinance.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: jingyan
 * @Time: 2017/9/20 11:12
 * @Describe:
 */
public class CsvFileUtil {

    private static final char SEPARATOR = ',';
    private static final String LINE_FEED = "\r\n";
    private FileChannel channel;
    private FileOutputStream fos;


    /**
     * @Author: jingyan
     * @Time: 2017/9/20 11:43
     * @Describe: 初始化写文件对象
     * @Param: appendable { true为追加文件，false为每次新写文件 }
     */
    public boolean initCsvWriter(String filePath, boolean appendable) {
        try {
            if (null == filePath || "".equals(filePath)) {
                return false;
            }
            File file = new File(filePath);
            // 如果父目录不存在，创建父目录
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            this.fos = new FileOutputStream(file, appendable);
            this.channel = fos.getChannel();
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
        System.out.println("close CsvFileUtil start...");
        try {
            if (null != this.channel) {
                this.channel.close();
            }
            if (null != this.fos) {
                this.fos.close();
            }
            System.out.println("close CsvFileUtil success...");
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
            //手动加入换行符
            String lineStr = this.arrayToString(line) + LINE_FEED;
            this.channel.write(ByteBuffer.wrap(lineStr.getBytes()));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Created with: jingyan.
     * Date: 2016/9/18  20:27
     * Description: list to String 加间隔符
     */
    public String arrayToString(String[] lineArray) {
        if (lineArray == null || lineArray.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lineArray.length; i++) {
            sb.append(lineArray[i]).append(SEPARATOR);
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }
}
