package com.example.demo.dao;

import com.example.demo.entity.Address;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AddressMapper {
    @Select("select addressId from address where addressId = #{addressId}")
    Address select(int addressId);

    @Insert("INSERT INTO address(addressId,userId, consigneeName, consigneePhoneNumber, specificAddress)  VALUES (null,#{userId},#{consigneeName},#{consigneePhoneNumber},#{specificAddress})")
    boolean add(Address address);

    @Update("update address set consigneeName=#{consigneeName},consigneePhoneNumber=#{consigneePhoneNumber},specificAddress=#{specificAddress} where addressId=#{addressId}")
    boolean update(Address address);

    @Delete("delete from address where addressId=#{addressId}")
    boolean delete(int addressId);

    @Select("select * from address where userId=#{userId}")
    List<Address> get(int userId);
}
