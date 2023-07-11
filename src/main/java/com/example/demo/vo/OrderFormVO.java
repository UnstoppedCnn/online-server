package com.example.demo.vo;

import java.util.List;

public class OrderFormVO {
    int orderId;
    List<OrderDetailVO> orderDetailVOS;
    int price;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<OrderDetailVO> getOrderDetailVOS() {
        return orderDetailVOS;
    }

    public void setOrderDetailVOS(List<OrderDetailVO> orderDetailVOS) {
        this.orderDetailVOS = orderDetailVOS;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public OrderFormVO(int orderId, List<OrderDetailVO> orderDetailVOS, int price) {
        this.orderId = orderId;
        this.orderDetailVOS = orderDetailVOS;
        this.price = price;
    }

    public OrderFormVO() {
    }
}
