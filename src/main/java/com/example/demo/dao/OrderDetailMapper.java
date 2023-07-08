package com.example.demo.dao;

import com.example.demo.entity.OrderDetail;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface OrderDetailMapper {
    @Select("select * from orderdetail where 1=1" +
            "<script>"+
            "<if test=\"orderId!=null and orderId!=''\">"
            +"and orderId=#{orderId}"
            +"</if>"
            +"<if test=\"productId!=null and productId!=''\">"
            +"and productId=#{productId}"
            +"</if>"
            +"<if test=\"productQuantity!=null and productQuantity!=''\">" +
            "and productQuantity=#{productQuantity}" +
            "</if>" +
            "<if test=\"productPrice!=null and procutPrice!=''>\"" +
            "and productPrice=#{productPrice}" +
            "</if>" +
            "</script>"
    )
    List<OrderDetail> searchBySth(OrderDetail orderDetail);
    @Delete("delete orderdetail where 1=1" +
            "<script>" +
            "<if test=\"orderId!=null and orderId!=''\">" +
            "and orderId=#{orderId}" +
            "</if>" +
            "<if test=\"productId!=null and productId!=''\">" +
            "and productId=#{productId}" +
            "</if>"+
            "<if test=\"productQuantity!=null and productQuantity!=''\">" +
            "and productQuantity=#{productQuantity}" +
            "</if>" +
            "<if test=\"productPrice!=null and productPrice!=''\">" +
            "and productPrice=#{productPrice}" +
            "</if>" +
            "</script>"
    )
    int deleteBySth(OrderDetail orderDetail);
    @Insert("insert into orderdetail values (#{userID},#{productId},#{productQuantity},#{productPrice})" )
    public int add(OrderDetail orderDetail);//返回值为插入几条记录
    @Update("update orderdetail set userID=#{userID},productId=#{productId},productQuantity=#{productQuantity},productPrice=#{productPrice}")
    public int update(OrderDetail orderDetail);
}
