package com.example.demo.vo;

import java.util.List;

public class OrderFormVO {
    int orderId;
    List<OrderDetailVO> productList;
    int price;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<OrderDetailVO> getProductList() {
        return productList;
    }

    public void setProductList(List<OrderDetailVO> productList) {
        this.productList = productList;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public OrderFormVO(int orderId, List<OrderDetailVO> productList, int price) {
        this.orderId = orderId;
        this.productList = productList;
        this.price = price;
    }

    public OrderFormVO() {
    }
}
