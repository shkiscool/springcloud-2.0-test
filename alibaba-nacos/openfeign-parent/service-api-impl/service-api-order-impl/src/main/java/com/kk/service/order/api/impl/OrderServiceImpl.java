package com.kk.service.order.api.impl;

import com.kk.service.order.api.openfeign.MemberServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceImpl {

     @Autowired
     private MemberServiceFeign memberServiceFeign;
    /**
     * 基于我们的fegin客户端形式实现rpc远程调用
     * @return
     */
    @RequestMapping("orderFeignToMember")
    public String orderFeignToMember() {
        String result = memberServiceFeign.getUser(1);
        return "订单服务会员" + result;
    }
}
