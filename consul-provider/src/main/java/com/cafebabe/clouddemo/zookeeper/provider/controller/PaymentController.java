package com.cafebabe.clouddemo.zookeeper.provider.controller;

import com.cafebabe.clouddemo.commom.api.entity.CommonResult;
import com.cafebabe.clouddemo.commom.api.entity.Payment;
import com.cafebabe.clouddemo.zookeeper.provider.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController()
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getPayment/{paymentNo}")
    public CommonResult getPaymentByid(@PathVariable("paymentNo") int paymentNo){
        Payment payment = paymentService.getPaymentById(paymentNo);
        return new CommonResult(200,"查询成功"+serverPort,payment);
    }

    @PostMapping("/insertPayment")
    public CommonResult insertPayment(Payment payment){
        int result = paymentService.insertPayment(payment.getPaymentName(), payment.getCount());
        if(result > 0){
            return new CommonResult(200,"插入成功",result);
        }else{
            return new CommonResult(433,"插入失败");
        }
    }
}
