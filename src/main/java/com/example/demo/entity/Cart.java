package com.example.demo.entity;

public class Cart {
    private Integer userId;
    private Integer productId;
    private Integer size;
    private String color;
    private Integer sum;

    @Override
    public String toString() {
        return "Cart{" +
                "catId=" + userId +
                ", productId=" + productId +
                ", size=" + size +
                ", color='" + color + '\'' +
                ", sum=" + sum +
                '}';
    }

    public Cart(Integer cartId, Integer productId, Integer size, String color, Integer sum) {
        this.userId = cartId;
        this.productId = productId;
        this.size = size;
        this.color = color;
        this.sum = sum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
}
