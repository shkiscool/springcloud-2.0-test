package com.kk.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @GetMapping("getMember")
    public String getMember() {
        return "alibaba test";
    }
}
