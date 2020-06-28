package com.kk.service.member.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
public class AppMember {

    public static void main(String[] args) {
        SpringApplication.run(AppMember.class, args);
    }
}
