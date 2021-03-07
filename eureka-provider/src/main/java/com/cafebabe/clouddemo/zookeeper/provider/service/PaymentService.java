package com.cafebabe.clouddemo.zookeeper.provider.service;


import com.cafebabe.clouddemo.commom.api.entity.Payment;

public interface PaymentService {
    Payment getPaymentById(int paymentNo);

    int insertPayment(String paymentName,int count);
}
