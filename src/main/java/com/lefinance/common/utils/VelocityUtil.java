package com.lefinance.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.velocity.VelocityEngineUtils;

import java.util.Map;

/**
 * @Author: jingyan
 * @Time: 2017/7/27 11:16
 * @Describe: Velocity工具类
 */
public class VelocityUtil {

    private static Logger logger = LoggerFactory.getLogger(VelocityUtil.class);
    private static VelocityEngine velocityEngine = null;
    private static final String TEMPLATE_LOCAL_DIRECTORY = "template/";

    /**
     * @Author: jingyan
     * @Time: 2017/7/27 13:45
     * @Describe: 静态代码块，类被第一次加载时，初始化执行一次，以后均不执行;
     *             初始化 {velocityEngine} 对象
     */
    static {
        logger.debug("velocityEngine init...");
        velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.setProperty("input.encoding", "utf-8");
        velocityEngine.setProperty("output.encoding", "utf-8");
        velocityEngine.init();
        logger.debug("velocityEngine successed...");
    }

    /**
     * @Author: jingyan
     * @Time: 2017/7/27 11:28
     * @Describe: 通过模板生成新文件
     */
    public static String mergeTemplateFile(String templateFileName, Map<String, Object> map, String newFilePath, String newFileName) {
        logger.info("mergeTemplateFile 参数为：templateFileName={},newFilePath={},newFileName={},map={}",
                templateFileName, newFilePath, newFileName, JSONObject.toJSONString(map));
        String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, TEMPLATE_LOCAL_DIRECTORY + templateFileName, "UTF-8", map);
        logger.debug("替换模板后的字符串为：body={}", body);
        String newFileFullPath = FileUtil.createFile(body, newFilePath, newFileName);
        logger.info("生成的文件路径为：newFileFullPath={}", newFileFullPath);
        return newFileFullPath;
    }
}
