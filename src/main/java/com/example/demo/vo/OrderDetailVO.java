package com.example.demo.vo;

public class OrderDetailVO {
    String productName;
    String brand;
    Integer size;
    String color;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public OrderDetailVO(String productName, String brand, Integer size, String color) {
        this.productName = productName;
        this.brand = brand;
        this.size = size;
        this.color = color;
    }

    public OrderDetailVO() {
    }
}
