package com.example.consumerservice.controller.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chris.zhao@shijigroup.com
 * @Date 2020/9/22 3:04 下午
 **/
@RestController
public class HystrixController {

    //通过HystrixCommand注解，手动指定一个降级方法，出现异常后会调用该降级方法
    @RequestMapping("/getName")
    @HystrixCommand(fallbackMethod = "getNameFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")},
            threadPoolKey = "hystrixDemoThreadPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "30"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            })
    public String getName(String username) throws Exception{
        if(username.equals("zhihu")){
            return "this is zhihu";
        }else{
            throw new Exception();
        }
    }

    /**
     * 出错后会调用该降级方法，返回指定的信息
     * @param username
     * @return
     */
    public String getNameFallback(String username){
        return " this username is not exist ";
    }
}
