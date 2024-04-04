package com.atguigu.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration// 配置类
public class RestTemplateConfig {

    @Bean
    @LoadBalanced// 支持负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
