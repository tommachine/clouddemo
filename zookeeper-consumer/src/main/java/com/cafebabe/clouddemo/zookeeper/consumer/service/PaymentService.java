package com.cafebabe.clouddemo.zookeeper.consumer.service;

import com.cafebabe.clouddemo.commom.api.entity.CommonResult;
import com.cafebabe.clouddemo.zookeeper.consumer.service.impl.PaymentServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "cloud-payment-service", fallback = PaymentServiceImpl.class)
public interface PaymentService {

    @GetMapping("/payment/getPayment/{paymentNo}")
    CommonResult getPaymentByid(@PathVariable("paymentNo") int paymentNo);

    @PostMapping("/payment/insertPayment")
    CommonResult insertPayment(@RequestParam("paymentName") String paymentname, @RequestParam("count") Integer count);
}
