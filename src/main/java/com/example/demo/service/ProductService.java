package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDetail;

import java.util.List;

public interface ProductService {

    /**
     * 获取商品信息
     */
    List<Product> getAll();

    /**
     * 添加商品
     */
    boolean save(Product product);

    /**
     * 根据url的id来获取商品详细信息
     */
    List<ProductDetail> get(Product product);

    /**
     * 根据url来获取更新商品信息
     */
    boolean update(Product product);

    /**
     * 根据url的id来获取
     */
    boolean delete(Product product);

    Product getProductInfo(Product product);
}
