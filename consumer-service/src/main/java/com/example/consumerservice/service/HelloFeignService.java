package com.example.consumerservice.service;

import com.example.consumerservice.service.fallback.HelloFeignFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author chris.zhao@shijigroup.com
 * @Date 2020/9/22 1:43 下午
 **/
//name为服务提供者向注册中心注册的实例名
@FeignClient(name = "provider-service", fallback = HelloFeignFallbackService.class)
public interface HelloFeignService {
    //地址为服务提供者对外暴露的地址
    @RequestMapping(value = "/hello" , method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);
}
