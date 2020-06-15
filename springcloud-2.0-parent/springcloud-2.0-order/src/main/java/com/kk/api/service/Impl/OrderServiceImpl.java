package com.kk.api.service.Impl;

import com.kk.api.entity.UserEntity;
import com.kk.api.feign.MemberServiceFeign;
import com.kk.api.service.IOrderService;
import com.kk.base.BaseApiService;
import com.kk.base.ResponseBase;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceImpl extends BaseApiService implements IOrderService {
    @Autowired
    private MemberServiceFeign memberServiceFeign;

    @GetMapping("/orderToMember")
    public String orderToMember(String name) {
        UserEntity userEntity = memberServiceFeign.getMember(name);
        return userEntity == null ? "没有相关用户信息" : userEntity.toString();
    }

    //没有解决服务雪崩效应
    @RequestMapping("/orderToMemberUserInfo")
    public ResponseBase orderToMemberUserInfo() {
        return memberServiceFeign.getUserInfo();
    }

    @RequestMapping("/orderInfo")
    public ResponseBase orderInfo() {
        System.out.println("orderInfo:线程池名称" + Thread.currentThread().getName());
        return setResultSuccess();
    }

    /**
     * 解决服务雪崩效应
     * Hystrix 有两种方式配置保护服务 通过注解和接口形式
     * @HystrixCommand 默认开启线程池隔离方式,开启服务降级，开启服务熔断
     * 设置hystrix超时时间  禁止hystrix超时时间默认1秒 如果在一秒中没有及时响应的话，默认情况下业务逻辑是可以执行的，
     * 但是直接执行服务降级方法
     */
    @HystrixCommand(fallbackMethod = "orderToMemberUserInfoFallBackMethod")
    @RequestMapping("/orderToMemberUserInfoHystrix")
    public ResponseBase orderToMemberUserInfoHystrix() {
        System.out.println("orderToMemberUserInfoHystrix:线程池名称" + Thread.currentThread().getName());
        return memberServiceFeign.getUserInfo();
    }

    /**
     * fallbackMethod 方法的作用：服务降级
     *
     * @return
     */
    public ResponseBase orderToMemberUserInfoFallBackMethod() {
        return setResultSuccess("返回一个友好的提示：服务降级,亲服务器忙，请稍后重试");
    }
    //hystrix 第二种写法 类的方式
    @RequestMapping("/orderToMemberUserInfoHystrix_demo2")
    public ResponseBase orderToMemberUserInfoHystrixDemo2() {
        System.out.println("orderToMemberUserInfoHystrix:线程池名称" + Thread.currentThread().getName());
        return memberServiceFeign.getUserInfo();
    }
}
