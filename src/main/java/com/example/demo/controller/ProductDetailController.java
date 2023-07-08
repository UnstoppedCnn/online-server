package com.example.demo.controller;

import com.example.demo.entity.ProductDetail;
import com.example.demo.model.Model;
import com.example.demo.service.impl.ProductDetailImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "商品详情管理")
@RestController
public class ProductDetailController {

    @Resource
    ProductDetailImpl productDetailImpl;
    @PostMapping("/productDetail")
    @ApiOperation(value = "添加商品详情",notes = "根据product对象来创建商品")
    public Model save(@RequestBody ProductDetail productDetail){
        if (productDetail==null) {
            return new Model(-1, "请输入正确的信息");
        }
        List<ProductDetail> list=productDetailImpl.searchProductDetail(productDetail);
        if(list.size()==0){
            return new Model(-1,"请检查您的检索信息");
        }
        productDetailImpl.saveProduct(productDetail);
        return new Model(1,"商品详情");
    }

    @DeleteMapping("/productDetail")
    @ApiOperation(value = "删除商品详情",notes = "根据")
    public Model delete(@RequestBody ProductDetail productDetail){
        //System.out.println("ppp"+productDetail.getColor()+productDetail.getSum());
        if (productDetail==null) {
            return new Model(-1, "请输入正确的信息");
        }
        List<ProductDetail>list=productDetailImpl.searchProductDetail(productDetail);
        if(list.size()==0)
            return new Model<>(-1,"没有此商品");
        productDetailImpl.deleteProduct(productDetail);
        return new Model(1,"删除成功");
    }
    @PutMapping("/productDetail")
    @ApiOperation(value = "更新商品详情",notes = "根据")
    public Model update(@RequestBody ProductDetail productDetail){
        if (productDetail==null){
            return new Model(-1,"请输入正确的信息");
        }
        List<ProductDetail>list=productDetailImpl.searchProductDetail(productDetail);
        if(list.size()==0)
            return new Model(-1,"请找后端开发人员zzj阁下");
        productDetailImpl.updateProduct(productDetail);
            return new Model(1,"更新成功");
    }
}
