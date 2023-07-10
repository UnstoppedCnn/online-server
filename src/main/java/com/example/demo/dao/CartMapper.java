package com.example.demo.dao;

import com.example.demo.entity.Cart;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CartMapper {

    @Select("select * from cart")
    public List<Cart> getAll();

    @Insert("insert into cart values (#{userId},#{productId},#{size},#{color},#{sum})")
    boolean add(Cart cart);//返回值为插入几条记录

    @Update("update cart set userId=#{userId},productId=#{productId},size=#{size},color=#{color},sum=#{sum} where userId=#{userId} and " +
            "productId=#{productId} and size=#{size} and color =#{color}")
    boolean update(Cart cart);

    @Delete("delete from cart where userId=#{userId}")
    boolean delete(Cart cart);

    @Select("select * from cart where userId=#{userId}")
    List<Cart> searchById(int userId);

}