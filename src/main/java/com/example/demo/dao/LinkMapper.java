package com.example.demo.dao;

import com.example.demo.entity.Link;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LinkMapper {
    @Select("select * from Link")
    List<Link> getAll();

    @Insert("        INSERT INTO link (linkName, linkURL, linkPrice, linkType, creationTime ,endTime)\n" +
            "        VALUES (#{linkName}, #{linkURL}, #{linkPrice}, #{linkType}, #{creationTime},#{endTime})")
    boolean add(Link link);

    @Delete("delete from link where linkId=#{linkId}")
    boolean delete(int linkId);

    @Select("select * from link where linkId=#{linkId}")
    Link get(int linkId);
}
