package com.kk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @EnableConfigServer 开启config Server服务器端
 * 在git环境上创建配置文件命名规范
 * 会员服务 -- 服务名称 -- member
 * 服务名称-环境.properties/yml
 * member-dev.properties
 *
 * 默认更新配置文件不能时时同步配置信息
 * springcloud 分布式配置中心可以采用手动刷新或者自动刷新
 * 手动刷新--需要人工调用接口 读取最新配置文件（监控中心）
 * 自动刷新--消息总线进行实时获取通知 springbus
 * 手动刷新和自动刷新都不需要重启服务器
 * 在公司当中，不建议大家使用自动刷新功能，因为对性能不是很好 建议使用手动刷新
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class AppConfigServer {

    public static void main(String[] args) {
        SpringApplication.run(AppConfigServer.class, args);
    }
}
