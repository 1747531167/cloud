package com.atguigu.cloud.controller;


import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PayController {
    @Resource
    private PayService payService;

    @PostMapping("/pay/add")
    public ResultData<String> addPay(@RequestBody Pay pay){
        System.out.println(pay.toString());

        int add = payService.add(pay);

        return ResultData.success("成功插入返回值： " + add);
    }

    @GetMapping("/pay/del/{id}")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id){
        int delete = payService.delete(id);
        return ResultData.success(delete);
    }
    @PostMapping("/pay/update")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO){
        System.out.println("pay Update");
        Pay pay = new Pay();

        BeanUtils.copyProperties(payDTO,pay);

        int i = payService.update(pay);

        return ResultData.success("成功更新条数： " + i);
    }

    @GetMapping("/pay/get/{id}")
    public ResultData<Pay> getById(@PathVariable("id") Integer id){
        if(id == -4) throw new RuntimeException("id不能为负数");
        try {
            TimeUnit.SECONDS.sleep(62);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @GetMapping("/pay/get")
    public ResultData<List<Pay>> getAll(){
        List<Pay> all = payService.getAll();
        return ResultData.success(all);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/pay/get/info")
    private String getInfoByConsul(@Value("${atguigu.info}") String atguiguInfo)
    {
        return "atguiguInfo: "+atguiguInfo+"\t"+"port: "+port;
    }

}
