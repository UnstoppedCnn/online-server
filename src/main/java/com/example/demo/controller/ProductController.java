package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDetail;
import com.example.demo.model.Model;
import com.example.demo.service.impl.ProductDetailImpl;
import com.example.demo.service.impl.ProductImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "商品管理")
@RestController
public class ProductController {

    @Resource
    ProductImpl productImpl;
    @Resource
    ProductDetailImpl productDetailImpl;
    @CrossOrigin
    @GetMapping("/product")
    @ApiOperation(value = "获取商品信息",notes = "获取所有商品数据")
    public Model getAll(){
        List<Product> list= productImpl.getAll();
        if(list.size()==0){
            return  new Model(-1,"没有商品");
        }
        return new Model(1,"这是查询到所有商品信息",list);
    }

    @CrossOrigin
    @PostMapping("/product")
    @ApiOperation(value = "添加商品", notes = "根据product对象来创建商品")
    public Model save(@RequestBody Product product) {
        if (product == null) {
            return new Model(-1, "请输入正确的信息");
        }
        productImpl.save(product);
        return new Model(1, "创建商品成功");
    }

    @CrossOrigin
    @GetMapping("/product/{productid}")
    @ApiOperation(value = "查询详细信息", notes = "根据url的id来获取指定商品详情信息")
    public Model get(@PathVariable String productid) {
        if (productid == null) {
            return new Model(1, "请输入正确的id");
        }
        Product product = new Product();
        product.setProductId(Integer.parseInt(productid));
        Product product1 = productImpl.getProductInfo(product);
        return new Model<>(1, "查找到啦", product1);
    }

    @CrossOrigin
    @PutMapping("/product")
    @ApiOperation(value = "更新信息", notes = "根据url的id来获取更新商品信息")
    public Model update(@RequestBody Product product) {
        if (product.getProductId() == null) {
            return new Model(-1, "请输入正确商品信息");
        }
        productImpl.update(product);
        return new Model(1, "更新用户商品成功");
    }

    @CrossOrigin
    @DeleteMapping("/product/{id}")
    @ApiOperation(value = "删除商品",notes = "根据url的id来获取删除商品信息")
    public Model delete(@PathVariable String id){
        if (id==null){
            return new Model(-1,"请输入正确的id");
        }
        ProductDetail productDetail=new ProductDetail();
        productDetail.setProductId(Integer.parseInt(id));
        productDetailImpl.deleteProduct(productDetail);
        Product product=new Product();
        product.setProductId(Integer.parseInt(id));
        productImpl.delete(product);
        return new Model(1,"删除该商品成功");
    }

}
