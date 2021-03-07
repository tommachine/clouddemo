package com.cafebabe.clouddemo.zookeeper.consumer.controller.openfeign;

import com.cafebabe.clouddemo.commom.api.entity.CommonResult;
import com.cafebabe.clouddemo.zookeeper.consumer.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/openfeign")
public class OpenFeignController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("/getOrder/{orderId}")
    public CommonResult getOrderByIdByOpenFeign(@PathVariable("orderId") Integer orderId) {
        CommonResult result = paymentService.getPaymentByid(orderId);
        return result;
    }

    @PostMapping("/insertOrder")
    public CommonResult insertOrderByOpenFeign(String orderName) {
      /*Payment payment = new Payment();
        payment.setPaymentName(orderName);
        payment.setCount(3);*/
        CommonResult commonResult = paymentService.insertPayment(orderName, 3);
        return commonResult;
    }


}
