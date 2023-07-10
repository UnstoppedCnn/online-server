package com.example.demo.dao;

import com.example.demo.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert("insert into product(productType,brand,productName,itemNo,originalPrice,currentPrice,productImg,productAddress,sex,status)"+
            "values(#{productType},#{brand},#{productName},#{itemNo},#{originalPrice},#{currentPrice},#{productImg},#{productAddress},#{sex},#{status})"
    )
    int save(Product pro);
    @Select("<script>"+
            "select * from product where 1=1"
            +"<if test=\" sex!=null and sex !=''\">" +
            " and sex=#{sex}</if>"
            +"<if test=\"productType!=null and productType !=''\">" +
            " and productType=#{productType}</if>"
            +"<if test=\"brand!=null and brand !=''\">" +
            " and brand=#{brand}</if>"
            +"<if test=\"productName!=null and productName !=''\">" +
            " and productName=#{productName}</if>"
            +"<if test=\"itemNo!=null and itemNo !=''\">" +
            " and itemNo=#{itemNo}</if>"
            +"<if test=\"originalPrice!=null and originalPrice !=''\"> " +
            "and originalPrice=#{originalPrice}</if>"
            +"<if test=\"currentPrice!=null and currentPrice !=''\"> " +
            "and currentPrice=#{currentPrice}</if>"
            +"<if test=\"productImg!=null and productImg !=''\">" +
            " and productImg=#{productImg}</if>"
            +"<if test=\"productAddress!=null and productAddress !=''\"> " +
            "and productAddress=#{productAddress}</if>"
            +"<if test=\"status!=null and status !=''\"> " +
            "and status=#{status}</if>"
            +"</script>"
    )
    List<Product> getAll();


    //删除
    @Delete("delete from product where productId=#{productId}")
     int delete(Product product);


    //更新
  @Update("update product set productType=#{productType},brand=#{brand}," +
          "productName=#{productName},itemNo=#{itemNo},originalPrice=#{originalPrice},currentPrice=#{currentPrice}," +
          "productImg=#{productImg},productAddress=#{productAddress},sex=#{sex},status=#{status} " +
          "where productId=#{productId}")
    public int update(Product pro);

  @Select("select * from product where productId=#{productId} ")
      //public Product searchById(int productId);
  Product getProductInfoById(Product product);
}
