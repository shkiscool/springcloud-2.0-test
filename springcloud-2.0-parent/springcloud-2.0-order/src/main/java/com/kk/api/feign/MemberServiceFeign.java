package com.kk.api.feign;

import com.kk.api.fallback.MemberServiceFallback;
import com.kk.api.service.IMemberService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 服务雪崩效应
 * 解释：默认情况下Tomcat只有一个线程池去处理客户端发送的所有服务请求
 * 这样的话在高并发情况下，如果客户端所有的请求堆积到同一个服务接口上，
 * 就会产生Tomcat的所有线程去处理该服务接口，可能会导致其他服务接口无法服务访问
 * 就会导致其他服务器接口访问的时候，产生延迟和等待
 *
 *
 * Hystrix服务保护框架，在微服务中Hystrix能够为我们解决那些事情
 *  * 1、断路器
 *  * 2、服务降级
 *  *    在高并发情况下，防止用户一直等待(在Tomcat中没有线程进行处理客户端请求的时候，不应该让用户一直在转图等待)，
 *  *    使用服务降级方式（返回一个友好的提示直接给客户端，不会去处理请求调用fallBack）目的是为了用户体验。
 *  *    秒杀---当前请求人数过多，请稍后重试。
 *  *    设置hystrix超时时间  禁止hystrix超时时间默认1秒 如果在一秒中没有及时响应给客户端（浏览器调用）的话，默认情况下业务逻辑是可以执行的，
 *  *    但是直接执行服务降级方法
 *  * 3、服务熔断：
 *  *    服务熔断目的是为了保护服务（保险丝），如果请求达到了一定的极限（可以设置阈值） 如果流量超出了设置的阈值
 *  *    自动开启保护服务功能，使用服务降级方式返回一个友好的提示，服务熔断机制和服务降级一起使用
 *  * 4、服务隔离机制
 *  *    线程池和信号量隔离。
 *  *    线程池隔离机制：每个服务接口都有自己独立的线程池，每个线程池互补影响。缺点：cpu占用率非常高，不是所有的接口都去采用线程池隔离，核心关键接口
 *  * 5、服务雪崩效应
 */
@FeignClient(value = "app-kk-member", fallback = MemberServiceFallback.class)
public interface MemberServiceFeign extends IMemberService {
}
