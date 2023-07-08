package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.dao.*;
import com.example.demo.service.CartService;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Service
public class CartImpl implements CartService {
    @Resource
    AddressMapper addressMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    CartMapper cartMapper;
    @Resource
    ProductMapper productMapper;
    @Resource
    ProductDetailMapper productDetailMapper;
    @Resource
    OrderDetailMapper orderDetailMapper;
    @Resource
    OrderFormMapper orderFormMapper;
    @Override
    public boolean addProductToCart(Cart cart, ProductDetail productDetail) {
        if(cart==null||productDetail==null){
            return false;
        }
        Cart cart1=new Cart(cart.getUserId(),productDetail.getProductId(),productDetail.getSize(),productDetail.getColor(),productDetail.getSize());
        List<ProductDetail> list= productDetailMapper.searchProductDetail(productDetail);
        if(list.get(0).getSum()>=productDetail.getSum()){
            return false;//库存不足
        }
        boolean value=cartMapper.add(cart1);
        return value;
    }

    @Override
    public List<Cart> getCartInfo(Cart cart) {
        if(cart==null){
            return null;
        }
        return cartMapper.searchById(cart.getUserId());
    }

    @Override
    public Integer createOrder(Cart cart,Address address) {
        boolean value;
        if(cart==null){
            return null;
        }
        OrderDetail orderDetail=new OrderDetail();
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        Product product=new Product();
        User user1=userMapper.searchById(cart.getUserId());
        List<Cart> carts=cartMapper.searchById(cart.getUserId());
        address=addressMapper.select(address.getAddressId());
        Integer temp=0;
        for (int i=0;i<carts.size();i++){
            product.setProductId(cart.getProductId());
            List<Product> products=productMapper.get(product);
            temp+=Integer.parseInt(products.get(0).getCurrentPrice())*cart.getSum();
        }

        OrderForm orderForm=new OrderForm(0,user1.getUserName(),address.getSpecificAddress(),temp,1,
                timestamp,null,null,null);
        orderFormMapper.add(orderForm);
        orderForm=orderFormMapper.searchanything(orderForm);
        for(int i=0;i<carts.size();i++){
            product.setProductId(cart.getProductId());
            List<Product> products=productMapper.get(product);
            orderDetail.setOrderId(orderForm.getOrderId());
            orderDetail.setProductId(carts.get(i).getProductId());
            orderDetail.setProductQuantity(carts.get(i).getSum());
            orderDetail.setProductPrice(Double.parseDouble(products.get(i).getCurrentPrice()));
        }
        return 1;
    }

    @Override
    public boolean deleteCart(Cart cart) {
        if(cart==null)
            return false;
        boolean value=cartMapper.delete(cart);
        return value;
    }
}
