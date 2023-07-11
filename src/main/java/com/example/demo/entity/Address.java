package com.example.demo.entity;

public class Address {


    private Integer userId;

    private String consigneeName;
    private String consigneePhoneNumber;
    private String specificAddress;
    private Integer addressId;

    public Address(Integer userId, String consigneeName, String consigneePhoneNumber, String specificAddress, Integer addressId) {
        this.userId = userId;
        this.consigneeName = consigneeName;
        this.consigneePhoneNumber = consigneePhoneNumber;
        this.specificAddress = specificAddress;
        this.addressId = addressId;
    }

    public Address() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneePhoneNumber() {
        return consigneePhoneNumber;
    }

    public void setConsigneePhoneNumber(String consigneePhoneNumber) {
        this.consigneePhoneNumber = consigneePhoneNumber;
    }

    public String getSpecificAddress() {
        return specificAddress;
    }

    public void setSpecificAddress(String specificAddress) {
        this.specificAddress = specificAddress;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "userId=" + userId +
                ", consigneeName='" + consigneeName + '\'' +
                ", consigneePhoneNumber='" + consigneePhoneNumber + '\'' +
                ", specificAddress='" + specificAddress + '\'' +
                ", addressId=" + addressId +
                '}';
    }
}
