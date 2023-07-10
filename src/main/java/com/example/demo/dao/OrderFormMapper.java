package com.example.demo.dao;

import com.example.demo.entity.OrderForm;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderFormMapper {

    @Select("select * from orderform")
    public List<OrderForm> getAll();

    @Insert("insert into orderform values (null,#{userName},#{shippingAddress},#{integral},#{orderStatus},#{creationTime},#{paymentTime},#{removalTime},#{endTime})")
    boolean add(OrderForm orderForm);//返回值为插入几条记录

    @Update("update orderform where orderId=#{orderId} set userName=#{userName},shippingAddress=#{shippingAddress},integral=#{integral},orderStatus=#{orderStatus},creationTime=#{creationTime},paymentTime=#{paymentTime},removalTime=#{removalTime},endTime=#{endTime} where orderId=#{orderId}")
    boolean update(OrderForm orderForm);

    @Delete("delete from orderform where orderId=#{orderId}")
    boolean delete(OrderForm orderForm);

    @Select("select * from orderform where 1=1 <script>" +
            "<if test=\"userName!=null and userName!=''\">" +
            "and userName=#{userName}" +
            "</if>" +
            "<if test=\"shippingAddress!=null and shippingAddress!=''\">" +
            "and shippingAddress=#{shippingAddress}" +
            "</if>" +
            "<if test=\"intergral!=intergral and intergral=''\">" +
            "and intergral=#{intergral}" +
            "</if>" +
            "<if test=\"orderStatus!=orderStatus and orderStatus=''\">" +
            "and orderStaus=#{orderStatus}" +
            "</if>" +
            "</stript>")
    List<OrderForm> searchanything(OrderForm orderForm);
}