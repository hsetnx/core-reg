package com.lefinance.common.utils;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by chenyong6 on 2017/4/14.
 */
public class CommonUtils {

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    public static String getUUIDWithoutSeparator() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String get16RandCode(){
        String uuid = getUUID();
        int hashCodeVal = uuid.hashCode();
        if(hashCodeVal < 0){
            hashCodeVal = -hashCodeVal;
        }
        return String.format("%016d", hashCodeVal);
    }

    public static String getServerIP() {
        String ip = "127.0.0.1";
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            ip = localHost.getHostAddress();
        } catch (/* UnknownHost */Exception e) {
            // e.printStackTrace();
        }
        return ip;
    }

    public static int getUnixTimestamp() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static String formateDate(Date date, String formate){
        SimpleDateFormat formatter = new SimpleDateFormat(formate);
        String formatString = formatter.format(date);
        return formatString;

    }

    public static Date getDayStartTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getDayEndTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    public static void writeStringToFile(String filepath, String filename, String data) throws Exception{
        File file = new File(filepath, filename);
        try {
            FileUtils.writeStringToFile(file, data, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("文件写操作异常！");
        }
    }
}
