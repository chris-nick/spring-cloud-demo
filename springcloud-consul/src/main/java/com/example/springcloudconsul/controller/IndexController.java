package com.example.springcloudconsul.controller;

import com.example.springcloudconsul.config.StudentConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chris.zhao@shijigroup.com
 * @Date 2020/9/22 5:13 下午
 **/
@RestController
@RefreshScope
public class IndexController {

    @Value("${description:chris}")
    private String description;

    @Autowired
    private StudentConfig studentConfig;

    @RequestMapping("/description")
    public String testDescription() {
        System.out.println("description is : " + description);
        return description;
    }

    @RequestMapping("/config")
    public String testConfig() {
        System.out.println(studentConfig.toString());
        return studentConfig.toString();
    }
}
