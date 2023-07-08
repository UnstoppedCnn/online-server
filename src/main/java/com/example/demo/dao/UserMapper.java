package com.example.demo.dao;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> getAll();

    @Insert("insert into user values (null,#{userName},#{password},#{realName},#{sex},#{mail},#{telephone},#{integral},#{question},#{answer},#{authority},#{status},#{creationTime},#{updateTime})" )
    boolean add(User user);//返回值为插入几条记录

    @Update("update user set userName=#{userName},password=#{password},realName=#{realName},sex=#{sex},mail=#{mail},telephone=#{telephone},integral=#{integral},question=#{question},answer=#{answer},authority=#{authority},status=#{status},creationTime=#{creationTime},updateTime=#{updateTime} where userId=#{userId}")
    boolean update(User user);

    @Delete("delete from user where userId=#{userId}")
    boolean delete(User user);

    @Select("select * from user where userId=#{userId}")
    User searchById(int userId);

}