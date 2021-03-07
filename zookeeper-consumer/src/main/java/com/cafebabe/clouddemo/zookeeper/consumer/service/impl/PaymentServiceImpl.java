package com.cafebabe.clouddemo.zookeeper.consumer.service.impl;

import com.cafebabe.clouddemo.commom.api.entity.CommonResult;
import com.cafebabe.clouddemo.zookeeper.consumer.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceImpl implements PaymentService {

    public CommonResult getPaymentByid(int paymentNo) {
        return new CommonResult(200,"连接超时");
    }

    public CommonResult insertPayment(String paymentname, Integer count) {
        return new CommonResult(200,"连接超时");
    }
}
