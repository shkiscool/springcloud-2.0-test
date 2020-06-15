package com.kk.api.service;

import com.kk.base.ResponseBase;
import org.springframework.web.bind.annotation.GetMapping;

public interface IOrderService {
    //订单服务调用会员服务接口信息 feign
    @GetMapping("/orderToMember")
    public String orderToMember(String name);

    @GetMapping("/orderToMemberUserInfo")
    public ResponseBase orderToMemberUserInfo();

    @GetMapping("/orderInfo")
    public ResponseBase orderInfo();

}
