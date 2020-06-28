package com.kk.service.order.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AppOrder {

    public static void main(String[] args) {
        SpringApplication.run(AppOrder.class, args);
    }
}
