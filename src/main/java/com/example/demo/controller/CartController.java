package com.example.demo.controller;

import com.example.demo.entity.Address;
import com.example.demo.entity.Cart;
import com.example.demo.entity.ProductDetail;
import com.example.demo.model.Model;
import com.example.demo.service.impl.CartImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "购物车管理")
@RestController
public class CartController {
    @Resource
    CartImpl cartImpl;

    @CrossOrigin
    @GetMapping("/cart/{id}")
    @ApiOperation(value = "获取购物车信息", notes = "根据url的id获取购物车中所有数据")
    public Model getAll(@PathVariable String id) {
        //判断用户是否存在
        Cart cart = new Cart(Integer.parseInt(id), null, null, null, null);
        List<Cart> carts = cartImpl.getCartInfo(cart);
        return new Model(1, "查询成功", carts);
    }

    @CrossOrigin
    @PostMapping("/cart")
    @ApiOperation(value = "添加商品", notes = "根据url的id来添加至指定id的购物车中")
    public Model save(@RequestBody Cart cart) {
        //判断用户是否存在
        if (cart == null)
            return new Model<>(-1, "插入失败");
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(cart.getProductId());
        cartImpl.addProductToCart(cart, productDetail);
        return new Model(-1, "插入成功");
    }

    @CrossOrigin
    @PutMapping("/cart")
    @ApiOperation(value = "更新购物车的信息", notes = "根据传递的cart来确定是哪个id")
    public Model update(@PathVariable Cart cart) {
        //判断用户是否存在
        if (cart == null) {
            return new Model(-1, "请检查代码");
        }
        List<Cart> carts = cartImpl.getCartInfo(cart);
        if (carts.size() != 1)
            return new Model(-1, "传入的json或者输入的时候有空");
        List<Cart> cartList = cartImpl.getCartInfo(cart);
        for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i).getSize() == cart.getSize() && cartList.get(i).getColor() == cart.getColor()) {
                cartImpl.update(cart);
                return new Model(1, "更新成功");
            }
        }
        return new Model(-1, "代码错误");
    }

    @CrossOrigin
    @DeleteMapping("/cart/{id}")
    @ApiOperation(value = "删除购物车", notes = "根据url的userid来清空指定用户购物车")
    public Model delete(@PathVariable String id) {
        //需要查找用户是否存在
        Cart cart = new Cart(Integer.parseInt(id), null, null, null, null);
        cartImpl.deleteCart(cart);
        return new Model(1, "删除成功");
    }

}