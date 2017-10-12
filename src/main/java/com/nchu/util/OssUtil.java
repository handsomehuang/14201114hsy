package com.nchu.util;

import com.aliyun.oss.OSSClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 阿里云Oss工具类
 */
public class OssUtil {
    private static final String CONFIG_PROPERTIES = "properties/ossConfig.properties";
    public final static String endpoint;
    public final static String accessKeyId;
    public final static String accessKeySecret;
    public final static String bucketName;

    static {
        /*获取类加载器*/
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();
        /*读取配置文件*/
        InputStream in = loader.getResourceAsStream(CONFIG_PROPERTIES);
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        endpoint = properties.getProperty("endpoint");
        accessKeyId = properties.getProperty("accessKeyId");
        accessKeySecret = properties.getProperty("accessKeySecret");
        bucketName = properties.getProperty("bucketName");
    }

    public static OSSClient getOssClient() {
        return new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }
}
