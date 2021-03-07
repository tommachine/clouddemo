package com.cafebabe.clouddemo.zookeeper.provider.service.impl;

import com.cafebabe.clouddemo.commom.api.entity.Payment;
import com.cafebabe.clouddemo.zookeeper.provider.dao.PaymentDao;
import com.cafebabe.clouddemo.zookeeper.provider.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;


    public Payment getPaymentById(int paymentNo) {
        Payment payment = paymentDao.selectByPrimaryKey(paymentNo);
        return payment;
    }

    public int insertPayment(String paymentName, int count) {
        Payment payment = new Payment(paymentName,count);
        int insert = paymentDao.insert(payment);
        return insert;
    }
}
