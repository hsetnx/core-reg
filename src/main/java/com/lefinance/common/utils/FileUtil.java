package com.lefinance.common.utils;

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
     * @Time: 2017/9/6 16:48
     * @Describe: NIO 写入文件
     */
    public static String writeFileByNio(String filePath, String content, boolean appendable) {
        if (null == filePath || "".equals(filePath)) {
            return null;
        }
        FileOutputStream fos = null;
        FileChannel channel = null;
        try {
            File file = new File(filePath);
            // 如果父目录不存在，创建父目录
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            fos = new FileOutputStream(file, appendable);
            channel = fos.getChannel();
            ByteBuffer buf = ByteBuffer.wrap(content.getBytes());
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
        if (null == filePath || "".equals(filePath)) {
            return null;
        }
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

}