package com.kk.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "members")
public class MemberApiController {
    @Value("${server.port}")
    private String port;
    @GetMapping
    public String getMember() {
        return "this kk init springcloud,and kkiscool"+"端口号：" + port;
    }
}
