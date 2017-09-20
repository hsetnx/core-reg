package com.lefinance.common.utils;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: jingyan
 * @Time: 2017/7/27 10:51
 * @Describe: 文件工具类
 */
public class FileUtil {

    /**
     * @Author: jingyan
     * @Time: 2017/9/6 18:20
     * @Describe: 创建并写入文件
     * @Param : appendable 追加 还是 覆盖 文件
     */
    public static String createAndWriteFile(String filePath, String fileName, String content, boolean appendable) {
        try {
            //创建文件
            String fullPath = filePath + File.separator + fileName;
            File file = new File(fullPath);
            // 如果父目录不存在，创建父目录
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            // 如果文件不存在，就创建文件
            if (!file.exists()) {
                file.createNewFile();
            }
            //写入文件
            return writeFileByNio(fullPath, content, appendable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/9/7 10:03
     * @Describe: 写入文件
     */
    public static void writeStringToFile(String filepath, String filename, String data) throws Exception {
        File file = new File(filepath, filename);
        try {
            FileUtils.writeStringToFile(file, data, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("文件写操作异常！");
        }
    }

    /**
     * @Author: jingyan
     * @Time: 2017/9/6 16:45
     * @Describe: 创建文件
     */
    public static String createFile(String filePath, String fileName) {
        try {
            String fullPath = filePath + File.separator + fileName;
            File file = new File(fullPath);
            // 如果父目录不存在，创建父目录
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            // 如果已存在,删除旧文件
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            return fullPath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/9/6 16:48
     * @Describe: NIO 写入文件
     */
    public static String writeFileByNio(String filePath, String content, boolean appendable) {
        FileOutputStream fos = null;
        FileChannel channel = null;
        try {
            fos = new FileOutputStream(filePath, appendable);
            channel = fos.getChannel();
            ByteBuffer buf = ByteBuffer.wrap(content.getBytes());
            buf.put(content.getBytes());
            buf.flip();
            channel.write(buf);
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != channel) {
                    channel.close();
                }
                if (null != fos) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/9/6 17:54
     * @Describe: 读取文件（50M 以下 300ms 以内）
     */
    public static String readFileByNio(String filePath) {
        FileInputStream fis = null;
        FileChannel channel = null;
        try {
            fis = new FileInputStream(filePath);
            channel = fis.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());
            channel.read(buffer);
            buffer.flip();
            String content = new String(buffer.array(), "utf-8");
            buffer.clear();
            return content;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                channel.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static void writeFileByLine(FileChannel channel, ByteBuffer buf, String[] line) {
        try {
            String linStr = PubMethod.arrayToString(line, ',');
            channel.write(buf.wrap(linStr.getBytes("utf-8")), channel.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}