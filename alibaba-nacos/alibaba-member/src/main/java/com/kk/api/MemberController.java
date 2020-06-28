package com.kk.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("getMember")
    public String getMember() {
        return "alibaba test" + serverPort;
    }


}
