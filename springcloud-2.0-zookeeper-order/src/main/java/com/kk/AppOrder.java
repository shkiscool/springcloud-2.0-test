package com.kk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class AppOrder {
    public static void main(String[] args) {
        SpringApplication.run(AppOrder.class, args);
    }

    @Bean
    @LoadBalanced //@LoadBalanced就能让这个RestTemplate在请求时拥有客户端负载均衡的能力
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
