package com.example.springcloudconsul;

import com.example.springcloudconsul.config.StudentConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableDiscoveryClient
@EnableScheduling  //启用后，会定时拉取配置
@EnableConfigurationProperties({StudentConfig.class})
@SpringBootApplication
public class SpringcloudConsulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsulApplication.class, args);
    }

}
