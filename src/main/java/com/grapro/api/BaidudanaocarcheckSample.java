package com.grapro.api;

import com.baidu.aip.imageclassify.AipImageClassify;
import org.springframework.stereotype.Component;

@Component
public class BaidudanaocarcheckSample {
    //设置APPID/AK/SK
    public static final String APP_ID = "19529445";
    public static final String API_KEY = "qXVvVqEdO24WRB2Nc45OYx6Z";
    public static final String SECRET_KEY = "FLvdwPPunuqGWKrYNxGCGOWqxoF4YWQP";
    AipImageClassify client = null;

    public BaidudanaocarcheckSample(){

        // 初始化一个AipImageClassifyClient
        client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "classpath:log4j.properties");
    }
    public AipImageClassify getClient() {
        return client;
    }
}
