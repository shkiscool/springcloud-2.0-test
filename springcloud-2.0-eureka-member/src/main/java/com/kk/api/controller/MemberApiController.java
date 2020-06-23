package com.kk.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "members")
@Api("会员服务")
public class MemberApiController {
    @Value("${server.port}")
    private String port;

    @GetMapping
    @ApiOperation("获取会员")
    public String getMember() {
        return "this kk init springcloud,and kkiscool"+"端口号：" + port;
    }
}
