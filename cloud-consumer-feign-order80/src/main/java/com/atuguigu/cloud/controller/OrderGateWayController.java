package com.atuguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther zzyy
 * @create 2023-11-20 16:48
 */
@RestController
public class OrderGateWayController {
    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping(value = "/feign/pay/gateway/get/{id}")
    public ResultData getById1(@PathVariable("id") Integer id) {
        return payFeignApi.getById1(id);
    }

    @GetMapping(value = "/feign/pay/gateway/info")
    public ResultData<String> getGatewayInfo() {
        return payFeignApi.getGatewayInfo();
    }
}