package com.kk.api;

import com.kk.loadbalancer.RotationLoadBalancer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired //RestTemplate 他不是springcloud 写的 本身spring 支持http协议调用 实现http调用
    private RestTemplate restTemplate;

    @Autowired
    private RotationLoadBalancer rotationLoadBalancer;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("getOrder")
    public String getOrder() {
        return "alibaba test";
    }

    @GetMapping("orderToMember")
    public Object orderToMember() {
        // 1、根据服务名称从 注册中心获取集群列表地址
        ServiceInstance singleAdders = rotationLoadBalancer.getSingleAdders(discoveryClient.getInstances("kk-member"));
        // 2、列表任意选择一个 实现本地rpc调用rest
        String result = restTemplate.getForObject(singleAdders.getUri() + "/getMember", String.class);
        return "订单调用会员返回结果" + result;
    }

    @GetMapping("orderToMemberRibbon")
    public Object orderToMemberRibbon() {
        String result = restTemplate.getForObject("http://kk-member/getMember", String.class);
        return "订单调用会员返回结果" + result;
    }

    /**
     * 根据LoadBalancerClient 实现客户端负载均衡
     * @return
     */
    @GetMapping("loadBalancerClientMember")
    public Object loadBalancerClientMember() {
        ServiceInstance choose = loadBalancerClient.choose("kk-member");
        return choose;
    }
}
