package com.kk.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //在需要刷新的Bean上添加@RefreshScope注解  post 调用该服务的http://127.0.0.1:8882/actuator/refresh 启动刷新器 从cofnig server读取
public class TestController {
    @Value("${kk}")
    private String kk;

    @RequestMapping("kk")
    public String getKK(){
        return kk;
    }
}
