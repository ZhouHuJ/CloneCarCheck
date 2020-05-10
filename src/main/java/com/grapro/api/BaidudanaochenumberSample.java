package com.grapro.api;

import com.baidu.aip.ocr.AipOcr;
import org.springframework.stereotype.Component;

@Component
public class BaidudanaochenumberSample {
    //设置APPID/AK/SK
    public static final String APP_ID = "19535750";
    public static final String API_KEY = "YYVLvAzCzlGrT7NTKZiLoRmm";
    public static final String SECRET_KEY = "bEHzS0G1Rd2kKap4YGgUvSkKSAaASz61";
    AipOcr client = null;

    public BaidudanaochenumberSample(){
        // 初始化一个AipOcr
        client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "classpath:log4j.properties");
    }

    public AipOcr getClient() {
        return client;
    }
}
