package com.example.demo.entity;

public class Address {



    private Integer address;

    private String consigneeName;
    private String consigneePhoneNumber;
    private String specificAddress;
    private Integer addressId;

    public Address(Integer address, String consigneeName, String consigneePhoneNumber, String specificAddress, Integer addressId) {
        this.address = address;
        this.consigneeName = consigneeName;
        this.consigneePhoneNumber = consigneePhoneNumber;
        this.specificAddress = specificAddress;
        this.addressId = addressId;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
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
                "address=" + address +
                ", consigneeName='" + consigneeName + '\'' +
                ", consigneePhoneNumber='" + consigneePhoneNumber + '\'' +
                ", specificAddress='" + specificAddress + '\'' +
                ", addressId=" + addressId +
                '}';
    }
}
