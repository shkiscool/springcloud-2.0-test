package com.kk.api.service.impl;

import com.kk.api.entity.UserEntity;
import com.kk.api.service.IMemberService;
import com.kk.base.BaseApiService;
import com.kk.base.ResponseBase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberServiceImpl extends BaseApiService implements IMemberService {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/getMember")
    public UserEntity getMember(@RequestParam("name") String name) {
        UserEntity userEntity = new UserEntity();
         userEntity.setName(name);
         userEntity.setAge(18);
        return userEntity;
    }

    @RequestMapping("/getUserInfo")
    public ResponseBase getUserInfo() {
        System.out.println("会员开始被访问");
        try {
            //会员服务接口产生1.5秒的延迟
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("会员开始被访问结束");
        return setResultSuccess("订单接口调用服务接口成功"+port);
    }
}
