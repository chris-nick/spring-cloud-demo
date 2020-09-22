package com.example.consumerservice.config;

/**
 * @Author chris.zhao@shijigroup.com
 * @Date 2020/9/22 1:58 下午
 *
 *  配置okhttp与连接池
 *  * ConnectionPool默认创建5个线程，保持5分钟长连接
 **/

import feign.Feign;
import okhttp3.ConnectionPool;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class OkHttpConfig {

    @Bean
    public okhttp3.OkHttpClient okHttpClient(){
        return new okhttp3.OkHttpClient.Builder()
                //设置连接超时
                .connectTimeout(10 , TimeUnit.SECONDS)
                //设置读超时
                .readTimeout(10 , TimeUnit.SECONDS)
                //设置写超时
                .writeTimeout(10 , TimeUnit.SECONDS)
                //是否自动重连
                .retryOnConnectionFailure(true)
                .connectionPool(new ConnectionPool(10 , 5L, TimeUnit.MINUTES))
                .build();
    }
}
