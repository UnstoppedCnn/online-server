package com.example.demo.service.impl;


import com.example.demo.dao.ProductDetailMapper;
import com.example.demo.dao.ProductMapper;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDetail;
import com.example.demo.service.ProductDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ProductDetailImpl implements ProductDetailService {
    @Resource
    private ProductDetailMapper productDetailMapper;
    @Resource
    private ProductMapper productMapper;
    @Override
    public boolean saveProduct(ProductDetail productDetail) {
        if(productDetail==null||productDetail.getProductId()==null&&productDetail.getSum()!=null
                &&productDetail.getColor()!=null){
            return false;
        }
        List<ProductDetail> list=productDetailMapper.searchProductDetail(productDetail);
        if(list.size()!=0) {
            Integer temp=list.get(0).getSum()==null?0:list.get(0).getSum();
            list.get(0).setSum(temp + productDetail.getSum());
            productDetailMapper.updateProductDetail(list.get(0));
        }else{
            productDetailMapper.insertProductDetail(productDetail);
        }
        return true;
    }

    @Override
    public boolean deleteProduct(ProductDetail productDetail) {
        if(productDetail==null||productDetail.getProductId()==null){
            return false;
        }
        productDetailMapper.deleteProductDetailByAnything(productDetail);
        if(productDetail.getSize()==null&&productDetail.getColor()==null){
            Product product=new Product();
            product.setProductId(productDetail.getProductId());
            productMapper.delete(product);
        }
        return true;
    }

    @Override
    public boolean updateProduct(ProductDetail productDetail) {
        if(productDetail==null||productDetail.getProductId()==null){
            return false;
        }
        List<ProductDetail> list = productDetailMapper.SearchProductDetail(productDetail);
        //list.get(0).setSum(productDetail.getSum());
        productDetailMapper.updateProductDetail(productDetail);
        return true;
    }

    @Override
    public List<ProductDetail> searchProductDetail(ProductDetail productDetail) {
        return productDetailMapper.searchProductDetail(productDetail);
    }
}