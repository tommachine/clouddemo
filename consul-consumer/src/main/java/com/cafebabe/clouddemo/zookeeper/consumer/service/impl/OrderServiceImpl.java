package com.cafebabe.clouddemo.zookeeper.consumer.service.impl;

import com.cafebabe.clouddemo.zookeeper.consumer.dao.OrderMapper;
import com.cafebabe.clouddemo.zookeeper.consumer.entity.Order;
import com.cafebabe.clouddemo.zookeeper.consumer.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    public Order getOrderById(Long orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    public int insertOrder(String orderName) {
        Order order = new Order();
        order.setOrderName(orderName);
        return orderMapper.insert(order);
    }
}
