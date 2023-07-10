package com.example.demo.service;

import com.example.demo.entity.OrderForm;
import com.example.demo.entity.ProductDetail;
import org.springframework.stereotype.Service;

@Service
public interface OrderFormService {
    boolean updateOrderForm(OrderForm orderForm);

    OrderForm searchById(Integer id);

    boolean deleteOrderFormByAnything(OrderForm orderForm);

    boolean createOrderInCart(String userName, Integer addressId);

    boolean createOrderByInstance(String userName, ProductDetail productDetail, Integer addressId);
}
