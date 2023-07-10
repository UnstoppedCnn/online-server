package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    private Integer productId;
    private String productType;
    private String brand;
    private String productName;
    private String itemNo;
    private String originalPrice;
    private String currentPrice;
    private String ProductImg;
    private String productAddress;
    private Integer sex;
    private Integer status;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getProductImg() {
        return ProductImg;
    }

    public void setProductImg(String productImg) {
        ProductImg = productImg;
    }

    public String getProductAddress() {
        return productAddress;
    }

    public void setProductAddress(String productAddress) {
        this.productAddress = productAddress;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Product(Integer productId, String productType, String brand, String productName, String itemNo, String originalPrice, String currentPrice, String productImg, String productAddress, Integer sex, Integer status) {
        this.productId = productId;
        this.productType = productType;
        this.brand = brand;
        this.productName = productName;
        this.itemNo = itemNo;
        this.originalPrice = originalPrice;
        this.currentPrice = currentPrice;
        ProductImg = productImg;
        this.productAddress = productAddress;
        this.sex = sex;
        this.status = status;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productType='" + productType + '\'' +
                ", brand='" + brand + '\'' +
                ", productName='" + productName + '\'' +
                ", itemNo='" + itemNo + '\'' +
                ", originalPrice='" + originalPrice + '\'' +
                ", currentPrice='" + currentPrice + '\'' +
                ", ProductImg='" + ProductImg + '\'' +
                ", productAddress='" + productAddress + '\'' +
                ", sex=" + sex +
                ", status=" + status +
                '}';
    }
}
