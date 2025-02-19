package com.atguigu.cloud.controller;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PayCircuitController {
//    //=========Resilience4j CircuitBreaker 的例子
//    @GetMapping(value = "/pay/circuit/{id}")
//    public String myCircuit(@PathVariable("id") Integer id)
//    {
//        System.out.println("接收到传递的参数 ：" + id);
//        if(id == -4) throw new RuntimeException("----circuit id 不能负数");
//        if(id == 9999){
//            try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
//        }
//        return "Hello, circuit! inputId:  "+id+" \t " + IdUtil.simpleUUID();
//    }

    //=========Resilience4j CircuitBreaker 的例子
    @GetMapping(value = "/pay/bulkhead/{id}")
    public String myBulkHead(@PathVariable("id") Integer id){
        System.out.println("接收到传递的参数 ：" + id);
        if(id == -4) throw new RuntimeException("----bulkhead id 不能负数");
        if(id == 9999){
            try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        return "Hello, bulkhead! inputId:  "+id+" \t " + IdUtil.simpleUUID();
    }

    @GetMapping(value = "/pay/ratelimit/{id}")
    public String myRatelimit(@PathVariable("id") Integer id)
    {
        return "Hello, myRatelimit欢迎到来 inputId:  "+id+" \t " + IdUtil.simpleUUID();
    }

}
