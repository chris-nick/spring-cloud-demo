package com.example.eurekaclient.controller;

import com.example.eurekaclient.service.IIndexFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author chris.zhao@shijigroup.com
 * @Date 2020/9/22 11:39 上午
 **/
@RestController
public class IndexController {

    @Autowired
    private IIndexFeignService feignService;

    @RequestMapping(value = "/search" , method = RequestMethod.GET)
    public String search(@RequestParam("query") String query){
        return feignService.search(query);
    }

}
