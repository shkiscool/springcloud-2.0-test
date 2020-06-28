package com.kk.loadbalancer;

import java.util.List;
import org.springframework.cloud.client.ServiceInstance;

public interface LoadBalancer {

    /**
     * 从注册中心获取集群列表中单个地址
     * @param serviceInstances
     * @return
     */
    ServiceInstance getSingleAdders(List<ServiceInstance> serviceInstances);
}
