package com.lefinance.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.velocity.VelocityEngineUtils;

import java.util.HashMap;
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
    public static String mergeTemplateFile(String templateName, String newFilePath, Map<String, Object> paramMap) {
        logger.info("mergeTemplateFile 参数为：templateName={},newFilePath={},paramMap={}", templateName, newFilePath, JSONObject.toJSONString(paramMap));
        String content = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, TEMPLATE_LOCAL_DIRECTORY + templateName, "UTF-8", paramMap);
        logger.debug("替换模板后的字符串为：content={}", content);
        String newFileFullPath = FileUtil.writeFileByNio(newFilePath, content, false);
        logger.info("生成的文件路径为：newFileFullPath={}", newFileFullPath);
        return newFileFullPath;
    }

    public static void main(String[] args) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("title", "第一页");


        String a1 = ".a1{\n" +
                "    width: 150px;\n" +
                "    font-size: 10px;\n" +
                "    margin-top:5px;\n" +
                "}";
        String a2 = ".a2{\n" +
                "    width: 150px;\n" +
                "    font-size: 20px;\n" +
                "    margin-top:5px;\n" +
                "}";
        String a3 = ".a3{\n" +
                "    width: 150px;\n" +
                "    font-size: 40px;\n" +
                "    margin-top:5px;\n" +
                "}";
        String[] cssArray = {a1, a2, a3};

        String div1 = "<div class=\"a1\">\n" +
                "<a href=\"http:www.baidu.com\">汉字</a>"+
                "</div>";
        String div2 = "<div class=\"a2\">\n" +
                "汉字"+
                "</div>";
        String div3 = "<div class=\"a3\">\n" +
                "汉字"+
                "</div>";
        String[] divArray = {div1, div2, div3};
        paramMap.put("cssArray", cssArray);
        paramMap.put("divArray", divArray);
        mergeTemplateFile("html_template.vm", "D://aa.html", paramMap);
    }
}
