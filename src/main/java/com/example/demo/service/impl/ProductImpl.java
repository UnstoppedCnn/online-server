package com.example.demo.service.impl;

import com.example.demo.dao.ProductDetailMapper;
import com.example.demo.dao.ProductMapper;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDetail;
import com.example.demo.service.ProductDetailService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductDetailMapper productDetailMapper;

    @Override
    public List<Product> getAll() {
        return productMapper.getAll();
    }

    @Override
    public boolean delete(Product product) {
        return productMapper.delete(product) > 0?true:false;
    }

    @Override
    public boolean update(Product product) {
        int i = productMapper.update(product);
        return i > 0;
    }

    @Override
    public boolean save(Product product) {
        int i = productMapper.save(product);
        return i > 0;
    }

    @Override
    public List<ProductDetail> get(Product product) {
        ProductDetail productDetail=new ProductDetail();
        productDetail.setProductId(product.getProductId());
        return productDetailMapper.searchProductDetail(productDetail);
    }
}
