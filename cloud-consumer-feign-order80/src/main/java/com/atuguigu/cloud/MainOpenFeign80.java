package com.atuguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients("com.atguigu.*")// 启用feign客户端，定义接口+绑定服务，以声明式事务简单的实现服务调用
@EnableDiscoveryClient// 用于向使用consul注解中心时注册服务
public class MainOpenFeign80 {

    public static void main(String[] args) {
        SpringApplication.run(MainOpenFeign80.class,args);
    }
}
