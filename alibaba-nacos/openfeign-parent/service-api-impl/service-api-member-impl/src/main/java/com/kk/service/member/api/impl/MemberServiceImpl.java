package com.kk.service.member.api.impl;

import com.kk.service.member.api.MemberService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MemberServiceImpl implements MemberService {

    @Value("${server.port}")
    private String port;

    @Value("${kk.is}")
    private String descri;

    @Override
    public String getUser(@RequestParam("userId") Integer userId) {
        return "我是会员服务" + port;
    }

    @GetMapping("kk")
    public String getkk(HttpServletRequest request) {
        String serverPort = request.getHeader("serverPort");
        return "alibaba test网关端口号:" + serverPort;
    }
}
