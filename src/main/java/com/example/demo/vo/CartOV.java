package com.example.demo.vo;

public class CartOV {
    //productId,size,sum,color,currentprice,img,productName
    String productId;
    Integer size;
    Integer sum;
    String color;
    Double currentPrice;
    String productImg;
    String productName;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public CartOV(String productId, Integer size, Integer sum, String color, Double currentPrice, String productImg, String productName) {
        this.productId = productId;
        this.size = size;
        this.sum = sum;
        this.color = color;
        this.currentPrice = currentPrice;
        this.productImg = productImg;
        this.productName = productName;
    }

    public CartOV() {
    }

    @Override
    public String toString() {
        return "CartOV{" +
                "productId='" + productId + '\'' +
                ", size=" + size +
                ", sum=" + sum +
                ", color='" + color + '\'' +
                ", currentPrice=" + currentPrice +
                ", productImg='" + productImg + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
