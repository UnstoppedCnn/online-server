package com.example.demo.controller;
import com.example.demo.model.Model;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

public class OrderDetailController {

    @Api(tags = "订单管理")
    @RestController
    public class OrderController {
        @Resource

        @GetMapping("/orders/{id}")
        @ApiOperation(value = "获取订单详情信息",notes = "根据url的id来获取所有订单信息")
        public Model getAll(@PathVariable Integer id){
            return null;
        }

        @PutMapping("/order/{id}")
        @ApiOperation(value = "更新订单状态",notes = "根据url的id来更新订单状态")
        public String update(@PathVariable String id){
            return "";
        }

        @PostMapping("/order/{id}")
        @ApiOperation(value = "获取订单信息",notes = "根据url的id来获取订单信息")
        public String get(@PathVariable String id){
            return "";
        }

        @GetMapping("/order/{id}")
        @ApiOperation(value = "获取订单详情信息",notes = "根据url的id来获取订单详情信息")
        public String getDetail(@PathVariable String id){
            return "";
        }
    }

}
