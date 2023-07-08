package com.example.demo.service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Cart;
import com.example.demo.entity.ProductDetail;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CartService {
    boolean addProductToCart(Cart cart, ProductDetail productDetail);
    List<Cart> getCartInfo(Cart cart);
    Integer createOrder(Cart cart, Address address);
    boolean deleteCart(Cart cart);
}
