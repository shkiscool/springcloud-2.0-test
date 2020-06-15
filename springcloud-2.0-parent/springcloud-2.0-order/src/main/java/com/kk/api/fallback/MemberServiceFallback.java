package com.kk.api.fallback;

import com.kk.api.entity.UserEntity;
import com.kk.api.feign.MemberServiceFeign;
import com.kk.base.BaseApiService;
import com.kk.base.ResponseBase;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceFallback extends BaseApiService implements MemberServiceFeign {
    @Override
    public UserEntity getMember(String name) {
        return null;
    }

    @Override
    public ResponseBase getUserInfo() {
        return setResultError("服务器忙，请稍后重试!以类方式写服务降级");
    }
}
