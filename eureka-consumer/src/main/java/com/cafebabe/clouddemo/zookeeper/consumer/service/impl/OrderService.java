package com.cafebabe.clouddemo.zookeeper.consumer.service.impl;

import com.cafebabe.clouddemo.zookeeper.consumer.entity.Order;

public interface OrderService {
    Order getOrderById(Long orderId);
    int insertOrder(String orderName);
}
