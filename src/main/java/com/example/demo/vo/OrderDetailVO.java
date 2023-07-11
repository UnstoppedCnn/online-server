package com.example.demo.vo;

public class OrderDetailVO {
    String productName;
    String brand;
    Integer size;
    String color;
    Integer num;

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public OrderDetailVO(String productName, String brand, Integer size, String color, Integer num) {
        this.productName = productName;
        this.brand = brand;
        this.size = size;
        this.color = color;
        this.num = num;
    }

    public OrderDetailVO() {
    }
}
