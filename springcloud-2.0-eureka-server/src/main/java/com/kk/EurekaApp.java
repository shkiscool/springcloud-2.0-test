package com.kk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka、zookeeper、consul 注册中心 三则可相互替代
 * 1、为什么会产生Eureka自我保护机制（防止误剔除）
 * 为了防止EurekaClient 可以正常运行，但是与EurekaServer网络不通的情况下，EurekaServer不会EurekaClient服务进行剔除
 * 2、eureka自我保护机制：默认情况下EurekaClient定时向EurekaServer端发送心跳包。
 *    如果EurekaServer在一定的时间内没有收到EurekaClient发送心跳包
 *    便会直接从服务注册列表中剔除该服务。默认（90秒内），
 *    但是在短时间丢失了大量的服务实例心跳，这时候EurekaServer会开启自我保护机制，不会去剔除该服务
 * 3、什么环境开启自我保护机制
 *   本地环境：建议在本地环境禁止自我保护机制。
 *   生产环境：建议开启自我保护机制
 *   如何关闭自我保护机制：在eurekaServer 和 eurekaClient 端的application.yml中 添加配置相关的配置
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApp.class, args);
    }
}
