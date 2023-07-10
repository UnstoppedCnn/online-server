package com.example.demo.service;

import com.example.demo.entity.OrderForm;
import com.example.demo.entity.ProductDetail;
import org.springframework.stereotype.Service;

@Service
public interface OrderFormService {
    boolean updateOrderForm(OrderForm orderForm);

    OrderForm searchById(Integer id);

    boolean deleteOrderFormByAnything(OrderForm orderForm);

    boolean createOrderInCart(OrderForm orderForm);

    boolean createOrderByInstance(OrderForm orderForm, ProductDetail productDetail);
}
