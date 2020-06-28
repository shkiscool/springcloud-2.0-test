package com.kk.service.order.api.openfeign;

import com.kk.service.member.api.MemberService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("kk-member")
public interface MemberServiceFeign extends MemberService {

}
