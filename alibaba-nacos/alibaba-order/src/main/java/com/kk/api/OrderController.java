package com.kk.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping("getOrder")
    public String getOrder() {
        return "alibaba test";
    }

    @GetMapping("orderToMember")
    public String orderToMember() {
        // 1、根据服务名称从 注册中心获取集群列表地址
        List<ServiceInstance> instances =  discoveryClient.getInstances("kk-member");
        // 2、列表任意选择一个 实现本地rpc调用rest
        return "alibaba test";
    }
}
