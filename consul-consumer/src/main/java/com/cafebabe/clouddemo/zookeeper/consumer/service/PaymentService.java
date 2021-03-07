package com.cafebabe.clouddemo.zookeeper.consumer.service;

import com.cafebabe.clouddemo.commom.api.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("cloud-payment-service")
@RequestMapping("/payment")
public interface PaymentService {

    @GetMapping("/getPayment/{paymentNo}")
    CommonResult getPaymentByid(@PathVariable("paymentNo") int paymentNo);

    @PostMapping("/insertPayment")
    CommonResult insertPayment(@RequestParam("paymentName") String paymentname,@RequestParam("count") Integer count);
}
