package com.ddz.demo.po;

import java.sql.Timestamp;

public class Order {
    private Integer orderId;
    private Integer userId;
    private Timestamp orderTime;
    private Integer isPrice;

    public Order() {
    }

    public Order(Integer orderId, Integer userId, Timestamp orderTime, Integer isPrice) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderTime = orderTime;
        this.isPrice = isPrice;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getIsPrice() {
        return isPrice;
    }

    public void setIsPrice(Integer isPrice) {
        this.isPrice = isPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", orderTime=" + orderTime +
                ", isPrice=" + isPrice +
                '}';
    }
}
