package com.lefinance.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with jingyan
 * Time: 2017/7/16 22:19
 * Description: HttpClient 工具类
 */
public class HttpClientUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
    private static HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
    private static final String CHARSET = "utf-8";

    /**
     * Created with jingyan
     * Time: 2017/7/16 22:18
     * Description: httpPost
     */
    public static JSONObject httpPost(String url, Map<String, String> paramMap) {
        String jsonStr = httpPost(url, paramMap, CHARSET);
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        return jsonObject;
    }

    /**
     * Created with jingyan
     * Time: 2017/7/16 22:18
     * Description: httpGet
     */
    public static JSONObject httpGet(String url, Map<String, String> paramMap) {
        String paramStr = createLinkString(paramMap);
        String jsonStr = httpGet(url + "?" + paramStr);
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        return jsonObject;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/7/27 13:52
     * @Describe: httpPost
     */
    public static String httpPost(String url, Map<String, String> paramMap, String charset) {
        logger.info("httpPost url: " + url);
        logger.info("httpPost param: " + JSONObject.toJSONString(paramMap));
        // HttpClient
        CloseableHttpClient client = httpClientBuilder.build();
        HttpPost method = new HttpPost(url);
        // 设置请求和传输超时时
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000).build();
        method.setConfig(requestConfig);
        try {
            if (null != paramMap) {
                List<NameValuePair> list = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> e : paramMap.entrySet()) {
                    list.add(new BasicNameValuePair(e.getKey(), e.getValue()));
                }
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
                method.setEntity(entity);
            }
            CloseableHttpResponse response = client.execute(method);
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            logger.info("远程访问结果 ： " + result);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return result;
            } else {
                logger.error("httpPost请求失败：" + response.getStatusLine().getStatusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Created with: jingyan.
     * Date: 2016/9/20  11:45
     * Description: httpGet
     */
    public static String httpGet(String url) {
        logger.info("httpGet url: " + url);
        try {
            // HttpClient
            CloseableHttpClient client = httpClientBuilder.build();
            // 发get请求
            HttpGet request = new HttpGet(url);
            // 设置请求和传输超时时
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000)
                    .build();
            request.setConfig(requestConfig);
            CloseableHttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return EntityUtils.toString(response.getEntity(), "UTF-8");
            } else {
                logger.error("httpGet请求失败：" + response.getStatusLine().getStatusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Created with jingyan
     * Time: 2017/7/16 22:17
     * Description: GET 参数拼装
     */
    public static String createLinkString(Map<String, String> params) {
        logger.info("httpGet param: " + JSONObject.toJSONString(params));
        List<String> keys = new ArrayList<String>(params.keySet());
        String prestr = "";
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            if (i == keys.size() - 1) {// 拼接时，不包括最后一&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }
        return prestr;
    }

}
