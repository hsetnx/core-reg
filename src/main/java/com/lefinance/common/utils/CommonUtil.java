package com.lefinance.common.utils;


import java.net.InetAddress;
import java.util.UUID;

/**
 * @Author: jingyan
 * @Time: 2017/7/27 14:03
 * @Describe:
 */
public class CommonUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    public static String getUUIDWithoutSeparator() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String get16RandCode() {
        String uuid = getUUID();
        int hashCodeVal = uuid.hashCode();
        if (hashCodeVal < 0) {
            hashCodeVal = -hashCodeVal;
        }
        return String.format("%016d", hashCodeVal);
    }

    public static String getServerIP() {
        String ip = "127.0.0.1";
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            ip = localHost.getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ip;
    }

    public static int getUnixTimestamp() {
        return (int) (System.currentTimeMillis() / 1000);
    }



}
