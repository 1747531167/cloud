package com.atuguigu.cloud.controller;

import cn.hutool.core.date.DateUtil;
import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private PayFeignApi payFeignApi;

    @PostMapping("/feign/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO){
        System.out.println("第一步：模拟本地addOrder新增订单成功(省略sql操作)，第二步：再开启addPay支付微服务远程调用");
        ResultData<String> stringResultData = payFeignApi.addPay(payDTO);
        return stringResultData;
    }
    @GetMapping("/feign/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        System.out.println("-------支付微服务远程调用，按照id查询订单支付流水信息");
        ResultData resultData = null;
        try
        {
            System.out.println("调用开始-----:"+ DateUtil.now());
            resultData = payFeignApi.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("调用结束-----:"+DateUtil.now());
            ResultData.fail(ReturnCodeEnum.RC500.getCode(),e.getMessage());
        }
        return resultData;
    }

    @GetMapping("/feign/pay/get/info")
    public String getInfoByConsul(){
        String infoByConsul = payFeignApi.getInfoByConsul();
        return infoByConsul;
    }


    @GetMapping("consumer/pay/del/{id}")
    public ResultData deleteOrder(@PathVariable("id") Integer id){
        return payFeignApi.deleteOrder(id);
    }

    @PostMapping("/consumer/pay/update")
    public ResultData updateOrder(@RequestBody PayDTO payDTO) {
        return payFeignApi.updateOrder(payDTO);
    }

}
