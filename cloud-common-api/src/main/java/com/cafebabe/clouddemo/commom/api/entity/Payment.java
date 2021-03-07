package com.cafebabe.clouddemo.commom.api.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "CD_PAYMENT")
@Data
public class Payment implements Serializable {


    private static final long serialVersionUID = -5513878008646136691L;

    @Id
    private Long paymentNo;

    private String paymentName;

    private Integer count;

    public Payment(String paymentName, Integer count) {
        this.paymentName = paymentName;
        this.count = count;
    }

    public Payment(Long paymentNo, String paymentName, Integer count) {
        this.paymentNo = paymentNo;
        this.paymentName = paymentName;
        this.count = count;
    }

    public Payment() {
    }
}
