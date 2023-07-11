package com.example.demo.service;

import com.example.demo.entity.OrderForm;
import com.example.demo.entity.ProductDetail;
import com.example.demo.vo.OrderFormVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderFormService {
    boolean updateOrderForm(OrderForm orderForm);

    List<OrderFormVO> searchByUserName(String userName);

    boolean deleteOrderFormByAnything(OrderForm orderForm);

    boolean createOrderInCart(String userName, Integer addressId);

    boolean createOrderByInstance(String userName, ProductDetail productDetail, Integer addressId);

    OrderForm searchOrderFormByAnything(OrderForm orderForm);
}
