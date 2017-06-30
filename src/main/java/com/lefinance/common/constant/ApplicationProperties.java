package com.lefinance.common.constant;


import com.lefinance.common.utils.BundleUtil;

/**
 * @Author: jingyan
 * @Time: 2017/6/6 12:23
 * @Describe: 公共配置
 */
public class ApplicationProperties {

    private static final BundleUtil bundleUtil;
    static {
        bundleUtil = BundleUtil.newInstance("application");
    }

    public static String getString(String key) {
        return bundleUtil.getString(key);
    }

    public static String getString(String key , String defaultValue) {
        return bundleUtil.getString(key,defaultValue);
    }
}
