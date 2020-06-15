package com.kk.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "orders")
public class OrderApiController {
    /**
     * 在springcloud 中有两种方式调用rest, fegin (springCloud)
     * RestTemplate 是由springboot web 组件提供默认整合了ribbon负载均衡器
     * rest方式底层是采用httpclient技术
     */
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient; //可以获取注册中心上的服务端信息做本地的负载均衡。

    @GetMapping("/discoveryClientMember")
    public List<ServiceInstance> discoveryClientMember() {
       List<ServiceInstance> instances =  discoveryClient.getInstances("APP-KK-MEMBER");
        instances.forEach(item -> {
            System.out.println("url:"+ item.getUri());
        });
        return instances;
    }

    @GetMapping
    public String getOrder() {
        // 有两种方式，一种采用服务别名方式调用，另一种是直接调用
        //第一种直接调用没有走eureka
/*        String result = restTemplate.getForObject("http://192.168.192.1:8000/members", String.class);
        System.out.println("会员服务调用订单服务result:" + result);
        return result;*/
        // 第二种采用服务别名方式调用走eureka 如果使用rest方式以别名方式进行调用依赖于ribbon负载均衡器
        String url = "http://app-kk-member/members";
        String result = restTemplate.getForObject(url, String.class);
        System.out.println("会员服务调用订单服务result:" + result);
        return result;
    }
}
