package com.example.consumerservice.controller;

import com.example.consumerservice.service.HelloFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author chris.zhao@shijigroup.com
 * @Date 2020/9/22 1:44 下午
 **/
@RestController
public class IndexController {

    @Autowired
    private HelloFeignService feignService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/v1/hello" , method = RequestMethod.GET)
    public String hello(String name){
        return feignService.hello(name);
    }


    @GetMapping("/sayHello")
    public String sayHello(String name){
        String url = "http://provider-service/v2/hello?name=" + name;
        String result = restTemplate.getForObject(url , String.class);
        return result;
    }

    @RequestMapping("/hello")
    public String hello2(String name){
        return "hi " + name;
    }

    @RequestMapping("/timeout")
    public String timeout(){
        try{
            //睡5秒，网关Hystrix3秒超时，会触发熔断降级操作
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "timeout";
    }
}
