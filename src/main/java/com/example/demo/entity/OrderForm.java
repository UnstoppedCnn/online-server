package com.example.demo.entity;

import java.sql.Timestamp;

public class OrderForm {


    private Integer orderId;
    private String userName;
    private String shippingAddress;
    private Integer integral;
    private String orderStatus;

    private Timestamp creationTime;

    private Timestamp paymentTime;

    public OrderForm() {
    }

    private Timestamp removalTime;
    private Timestamp endTime;

    public OrderForm(Integer orderId, String userName, String shippingAddress, Integer integral, String orderStatus, Timestamp creationTime, Timestamp paymentTime, Timestamp removalTime, Timestamp endTime) {
        this.orderId = orderId;
        this.userName = userName;
        this.shippingAddress = shippingAddress;
        this.integral = integral;
        this.orderStatus = orderStatus;
        this.creationTime = creationTime;
        this.paymentTime = paymentTime;
        this.removalTime = removalTime;
        this.endTime = endTime;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Timestamp getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Timestamp paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Timestamp getRemovalTime() {
        return removalTime;
    }

    public void setRemovalTime(Timestamp removalTime) {
        this.removalTime = removalTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "orderForm{" +
                "orderId=" + orderId +
                ", userName='" + userName + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", integral=" + integral +
                ", orderStatus=" + orderStatus +
                ", creationTime=" + creationTime +
                ", paymentTime=" + paymentTime +
                ", removalTime=" + removalTime +
                ", endTime=" + endTime +
                '}';
    }
}
