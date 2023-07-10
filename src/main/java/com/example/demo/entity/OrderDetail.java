package com.example.demo.entity;

public class OrderDetail {
    Integer orderId;
    Integer productId;
    Integer size;
    String color;
    Integer productQuantity;
    Double productPrice;

    public OrderDetail() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public OrderDetail(Integer orderId, Integer productId, Integer size, String color, Integer productQuantity,
                       Double productPrice) {
        this.orderId = orderId;
        this.productId = productId;
        this.size = size;
        this.color = color;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
}
