package com.cafebabe.clouddemo.zookeeper.consumer.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "cd_order")
public class Order {
    @Id
    private Long orderId;
    private String orderName;
}
