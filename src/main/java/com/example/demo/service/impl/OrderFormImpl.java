package com.example.demo.service.impl;

import com.example.demo.entity.OrderForm;
import com.example.demo.dao.OrderFormMapper;
import com.example.demo.service.OrderFormService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service

public class OrderFormImpl implements OrderFormService {
    @Resource
    OrderFormMapper orderFormMapper;
    @Override
    public boolean updateOrderForm(OrderForm orderForm) {
        if(orderForm==null)
            return false;
        boolean value=orderFormMapper.update(orderForm);
        return value;
    }

    @Override
    public OrderForm searchById(Integer id) {
        OrderForm orderForm=new OrderForm();
        orderForm.setOrderId(id);
        OrderForm orderForm1=orderFormMapper.searchanything(orderForm);
        return orderForm1;
    }
}
