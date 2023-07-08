package com.example.demo.entity;

public class ProductDetail {


    private Integer productId;
    private Integer size;
    private String color;
    private Integer sum;

    public ProductDetail() {
    }

    public ProductDetail(Integer productId, Integer size, String color, Integer sum) {
        this.productId = productId;
        this.size = size;
        this.color = color;
        this.sum = sum;
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

    @Override
    public String toString() {
        return "productDetail{" +
                "productId=" + productId +
                ", size=" + size +
                ", color='" + color + '\'' +
                ", sum=" + sum +
                '}';
    }
}
