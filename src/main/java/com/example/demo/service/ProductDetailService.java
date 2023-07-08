package com.example.demo.service;

import com.example.demo.entity.ProductDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductDetailService {
    boolean saveProduct(ProductDetail productDetail);
    boolean deleteProduct(ProductDetail productDetail);
    boolean updateProduct(ProductDetail productDetail);
    List<ProductDetail> searchProductDetail(ProductDetail productDetail);
}
