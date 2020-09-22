package com.example.eurekaclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author chris.zhao@shijigroup.com
 * @Date 2020/9/22 1:25 下午
 **/
@FeignClient(name = "search-github" , url = "https://api.github.com")
public interface IIndexFeignService {

    @RequestMapping(value = "/search/repositories" , method = RequestMethod.GET)
    String search(@RequestParam("q") String query);
}
