package com.example.demo.service;


import com.example.demo.entity.Address;

import java.util.List;


public interface AddressService {
    boolean select(int addressId);
    boolean save(Address address);
    boolean delete(int addressId);
    boolean update(Address address);
    List<Address> get(int userId);
}
