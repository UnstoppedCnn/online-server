package com.example.demo.controller;
import com.example.demo.entity.OrderDetail;
import com.example.demo.model.Model;
import com.example.demo.service.impl.OrderDetailImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

public class OrderDetailController {

    @Api(tags = "订单管理，再正常的逻辑中，订单的商品信息是不可以更改和删除,即只有查询的功能。删除的时候只是在取消订单的时候删除的")
    @RestController
    public class OrderController {
        @Resource
        @Autowired
        OrderDetailImpl orderDetailImpl;

        @GetMapping("/orders/{id}")
        @ApiOperation(value = "获取订单详情信息", notes = "根据url的id来获取所有订单信息")
        public Model getAll(@PathVariable Integer orderid) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderid);
            List<OrderDetail> orderDetails = orderDetailImpl.searchOrdertail(orderDetail);
            return new Model(1, "查询到如下信息", orderDetails);
        }

    }

}
