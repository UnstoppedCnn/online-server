package com.example.demo.controller;

import com.example.demo.entity.OrderForm;
import com.example.demo.model.Model;
import com.example.demo.service.impl.OrderFormImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;

@Api(tags="订单状态管理")
@RestController("/ordertest")
public class OrederFormController {
    Timestamp timestamp=new Timestamp(System.currentTimeMillis());
    @Resource
    OrderFormImpl orderFormImpl;
    @GetMapping("/ordertest/update")
    @ApiOperation(value="更新订单信息",notes="根据json中的信息更新订单数据")
    public Model update(@PathVariable OrderForm orderForm){
        Integer integer=orderForm.getOrderStatus();
        if(orderForm==null)
            return new Model(-1,"输入错误，请重新输入");
        OrderForm orderForm1=orderFormImpl.searchById(orderForm.getOrderId());
        if(orderForm1==null)
            return new Model(-1,"未找到此订单");
        if(integer==null)
            return new Model(-1,"请确认输入的操作是否正确");
        else if(integer==2)
            orderForm.setPaymentTime(timestamp);
        else if(integer==3)
            orderForm.setRemovalTime(timestamp);
        else
            orderForm.setEndTime(timestamp);
        orderFormImpl.updateOrderForm(orderForm);
        return new Model(1,"订单信息更新成功");
    }
}

