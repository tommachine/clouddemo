package com.cafebabe.clouddemo.zookeeper.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.cafebabe.clouddemo.commom.api.entity.CommonResult;
import com.cafebabe.clouddemo.zookeeper.consumer.service.impl.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
@Log4j2
public class OrderController {
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private OrderService orderService;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/getOrder/{orderId}")
    public CommonResult getOrderById(@PathVariable("orderId")  Long orderId){
        CommonResult result = restTemplate.getForObject(PAYMENT_URL + "/payment/getPayment/"+orderId,CommonResult.class);
        return  result;
    }

    @PostMapping("/insertOrder")
    public CommonResult insertOrder(String orderName){
        MultiValueMap<String,Object> multiValueMap = new LinkedMultiValueMap<String,Object>();
        multiValueMap.add("paymentName",orderName);
        multiValueMap.add("count",2);
        CommonResult result = restTemplate.postForObject(PAYMENT_URL + "/payment/insertPayment", multiValueMap, CommonResult.class);
        log.info(JSONObject.toJSONString(result));
        int insertResult = orderService.insertOrder(orderName);
        if(insertResult > 0){
            return new CommonResult(200,"插入成功");
        }else{
            return new CommonResult(433,"插入失败");
        }

    }


}
