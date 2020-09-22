package com.example.consumerservice.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author chris.zhao@shijigroup.com
 * @Date 2020/9/22 2:49 下午
 * ribbon负载均衡配置
 * ribbon有7种策略，随机、轮询、最小并发、响应时间加权等策略
 **/
@Configuration
public class RibbonLBConfig {

    //使用随机策略
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
