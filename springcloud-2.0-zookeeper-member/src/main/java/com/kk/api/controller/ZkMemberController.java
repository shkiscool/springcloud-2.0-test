package com.kk.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequestMapping(value = "members")
@EnableDiscoveryClient //作用是如果服务使用consul、zookeeper使用 向注册中心上注册服务
public class ZkMemberController {

    @Value("${server.port}")
    private String port;

    @GetMapping
    public String getMember() {
        return "this kk init springcloud,and kkiscool"+"端口号：" + port;
    }

    public static void main(String[] args) {
        SpringApplication.run(ZkMemberController.class, args);
    }
}
