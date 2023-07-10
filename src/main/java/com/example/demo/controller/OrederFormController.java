package com.example.demo.controller;

import com.example.demo.entity.OrderForm;
import com.example.demo.entity.ProductDetail;
import com.example.demo.model.Model;
import com.example.demo.service.impl.OrderFormImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;

@Api(tags = "订单状态管理")
@RestController("/order")
public class OrederFormController {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    @Resource
    OrderFormImpl orderFormImpl;

    @CrossOrigin
    @PutMapping("/order/{id}")
    @ApiOperation(value = "更新订单信息", notes = "根据json中的信息更新订单数据")
    public Model update(@PathVariable OrderForm orderForm) {
        Integer integer = orderForm.getOrderStatus();
        if (orderForm == null)
            return new Model(-1, "输入错误，请重新输入");
        OrderForm orderForm1 = orderFormImpl.searchById(orderForm.getOrderId());
        if (orderForm1 == null)
            return new Model(-1, "未找到此订单");
        if (integer == null)
            return new Model(-1, "请确认输入的操作是否正确");
        else if (integer == 2)
            orderForm.setPaymentTime(timestamp);
        else if (integer == 3)
            orderForm.setRemovalTime(timestamp);
        else
            orderForm.setEndTime(timestamp);
        orderFormImpl.updateOrderForm(orderForm);
        return new Model(1, "订单信息更新成功");
    }

    @CrossOrigin
    @PostMapping("/orders")
    @ApiOperation(value = "生成订单", notes = "清除购物车的所有商品")
    public Model createOrderByCart(@RequestBody OrderForm orderForm) {
        orderFormImpl.createOrderInCart(orderForm);
        return new Model<>(1, "删除成功");
    }

    @CrossOrigin
    @PostMapping("/order")
    @ApiOperation(value = "立即购买并生成订单", notes = "将当前选中的物品申城订单")
    public Model createOrderByInstance(@RequestBody OrderForm orderForm, @RequestBody ProductDetail productDetail) {
        orderFormImpl.createOrderByInstance(orderForm, productDetail);
        return new Model<>(1, "删除成功");
    }
}

