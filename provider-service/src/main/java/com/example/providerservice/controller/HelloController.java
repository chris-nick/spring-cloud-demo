package com.example.providerservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chris.zhao@shijigroup.com
 * @Date 2020/9/22 1:38 下午
 **/
@RestController
public class HelloController {

    @RequestMapping("/v1/hello")
    public String hello(String name){

//        try {
//            //睡眠60秒，测试feign的熔断、降级
//            Thread.sleep(60 * 1000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return  "hello " + name;
    }
}
