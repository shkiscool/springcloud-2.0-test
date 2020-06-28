package com.kk.loadbalancer;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

@Component
public class RotationLoadBalancer implements LoadBalancer {

    /**
     *  原子类 从0开始
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance getSingleAdders(List<ServiceInstance> serviceInstances) {
        int index = atomicInteger.incrementAndGet() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
