package com.example.demo.dao;


import com.example.demo.entity.ProductDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductDetailMapper {
    @Insert("insert into productdetail(productId,size,color,sum) values(#{productId},#{size},#{color},#{sum})")
    int insertProductDetail(ProductDetail pd);
//    @Delete("delete productdetail where productId=#{productId}")
//    int deleteProductDetail(ProductDetail pd);
    @Update("update productdetail set sum=#{sum},size=#{size},color=#{color} where productId=#{productId} and " +
            "color=#{color} and size=#{size}")
    int updateProductDetail(ProductDetail pd);
    @Delete("<script>" +
            "delete from productdetail " +
            "where productId=#{productId}" +
            "<if test=\"size!=null and size!=''\">"
            + "and size=#{size}"
            + "</if>"
            + "<if test=\"color!=null and color!=''\">"
            + "and color=#{color}"
            + "</if>" +
            "</script>"
    )
    int deleteProductDetailByAnything(ProductDetail pd);
    @Select("<script>"+
            "select * from productdetail where 1=1" +
            "<if test=\"productId!=null and productId!=''\">"+
            "and productId=#{productId}"+
            "</if>"+
            "<if test=\"size!=null and size!=''\">"
            +"and size=#{size}"
            +"</if>"
            +"<if test=\"color!=null and color!=''\">"
            +"and color=#{color}"
            +"</if>" +
            "</script>"
    )
    List<ProductDetail> searchProductDetail(ProductDetail productDetail);



    @Select("<script>"+
            "select * from productdetail where 1=1" +
            "<if test=\"productId!=null and productId!=''\">"+
            "and productId=#{productId}"+
            "</if>"+
            "<if test=\"size!=null and size!=''\">"
            +"and size=#{size}"
            +"</if>"
            +"<if test=\"color!=null and color!=''\">"
            +"and color=#{color}"
            +"</if>"
            +"<if test=\"sum!=null and sum!=''\">"
            +"and sum=#{sum}"+
            "</if>"+
            "</script>")
    List<ProductDetail> SearchProductDetail(ProductDetail productDetail);
}
