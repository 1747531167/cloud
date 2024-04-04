package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    // private static final String PaymentSrv_URL = "http://localhost:8001";// 先写死，硬编码
    // 一旦使用微服务架构，RestTemplate 默认支持负载均衡，所以要在restTemplate加入容器的时候加上@LoadBalanced注解支持负载均衡
    private static final String PaymentSrv_URL = "http://cloud-payment-service";// 服务注册中心上的微服务名称

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add", payDTO, ResultData.class);
    }

    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/" + id, ResultData.class, id);
    }

    @GetMapping("consumer/pay/del/{id}")
    public ResultData deleteOrder(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/del/" + id, ResultData.class, id);
    }

    @PostMapping("/consumer/pay/update")
    public ResultData updateOrder(@RequestBody PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/update", payDTO, ResultData.class);
    }
    @GetMapping("/consumer/pay/get/info")
    private String getInfoByConsul(){
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/info", String.class);
    }

}
