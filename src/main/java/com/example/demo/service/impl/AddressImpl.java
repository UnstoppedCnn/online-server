package com.example.demo.service.impl;


import com.example.demo.dao.AddressMapper;
import com.example.demo.entity.Address;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressImpl implements AddressService {
    AddressMapper addressDao;
    @Autowired
    public AddressImpl(AddressMapper addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public boolean select(int addressId) {
        Address address=addressDao.select(addressId);
        return address!=null?true:false;
    }

    @Override
    public boolean save(Address address) {
        try {
            addressDao.add(address);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int addressId) {
        return addressDao.delete(addressId);
    }

    @Override
    public boolean update(Address address) {
        return addressDao.update(address);
    }

    @Override
    public List<Address> get(int userId) {
        return addressDao.get(userId);
    }
}
