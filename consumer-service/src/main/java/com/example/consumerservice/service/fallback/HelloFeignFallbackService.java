package com.example.consumerservice.service.fallback;

import com.example.consumerservice.service.HelloFeignService;
import org.springframework.stereotype.Service;

/**
 * @Author chris.zhao@shijigroup.com
 * @Date 2020/9/22 2:10 下午
 * hystrix服务降级处理，防止因超时、异常等导致的服务调用雪崩
 **/
@Service
public class HelloFeignFallbackService implements HelloFeignService {
    @Override
    public String hello(String name) {
        return "未找到 "+name;
    }
}
