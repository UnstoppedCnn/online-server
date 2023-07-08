package com.example.demo.entity;

public class OrderDetail {
    Integer orderId;
    Integer productId;
    Integer productQuantity;
    Double productPrice;

    public OrderDetail() {
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                ", productQuantity=" + productQuantity +
                ", productPrice=" + productPrice +
                '}';
    }

    public OrderDetail(Integer orderId, Integer productId, Integer productQuantity, Double productPrice) {
        this.orderId = orderId;
        this.productId = productId;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    public Integer getOrderId() {
        return orderId;
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
