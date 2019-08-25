package com.qw.common.api.order.entity;

import java.io.Serializable;

/**
 * Created by qinwei on 2019/8/24.
 */
public class Order implements Serializable {
    private Long id;

    private Long buerId ;

    private Double money ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBuerId() {
        return buerId;
    }

    public void setBuerId(Long buerId) {
        this.buerId = buerId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
