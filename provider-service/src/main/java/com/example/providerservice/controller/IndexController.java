package com.example.providerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author chris.zhao@shijigroup.com
 * @Date 2020/9/22 2:23 下午
 **/
@RestController
public class IndexController {

    @GetMapping("/v2/hello")
    public String hello(String name , HttpServletRequest request){
        //返回端口信息
        return " From Port : " + request.getServerPort() + " , hello " + name;
    }
}
