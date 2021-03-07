package com.cafebabe.clouddemo.zookeeper.consumer.controller.hystrix;

import com.cafebabe.clouddemo.commom.api.entity.CommonResult;
import com.cafebabe.clouddemo.zookeeper.consumer.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/hystrix")
@RestController
public class HystrixController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/getOrder_ok/{orderId}")
    public CommonResult getHystrixOkOrderById(@PathVariable("orderId") Integer orderId) {
        CommonResult result = paymentService.getPaymentByid(orderId);
        //result.setMessage("线程池：" + Thread.currentThread().getName() + "  " + "getOrder_ok" + "(〃'▽'〃)" + "  " + orderId);
        return result;
    }

    @GetMapping("/getOrder_fail/{orderId}")
    @HystrixCommand(fallbackMethod = "timeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public CommonResult getHystrixFailOrderById(@PathVariable("orderId") Integer orderId) {

        CommonResult result = paymentService.getPaymentByid(orderId);
        //result.setMessage("线程池：" + Thread.currentThread().getName() + " " + "getOrder_fail" + "o(╥﹏╥)o" + " " + orderId);
        return result;
    }

    public CommonResult timeOutHandler(Integer id) {
        return new CommonResult(200, "连接超时，请稍后再试！");
    }
}
