package com.example.demo.controller;

import com.example.demo.entity.OrderForm;
import com.example.demo.entity.ProductDetail;
import com.example.demo.model.Model;
import com.example.demo.service.impl.OrderFormImpl;
import com.example.demo.vo.OrderFormVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Api(tags = "订单状态管理")
@RestController("/order")
public class OrederFormController {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    @Resource
    OrderFormImpl orderFormImpl;

    @CrossOrigin
    @PutMapping("/order")
    @ApiOperation(value = "更新订单信息", notes = "根据json中的信息更新订单数据，管理员更新订单状态")
    public Model update(@PathVariable OrderForm orderForm) {
        if (orderForm.getOrderId() == null)
            return new Model(0, "联系zzj阁下进行扣工资处分");

        String status = orderForm.getOrderStatus();
        OrderForm orderForm1 = orderFormImpl.searchOrderFormByAnything(orderForm);

        if (orderForm1 == null)
            return new Model(-1, "未找到此订单");
        if (status == null)
            return new Model(-1, "请确认输入的操作是否正确");
        else if (status == "2")
            orderForm.setPaymentTime(timestamp);
        else if (status == "3")
            orderForm.setRemovalTime(timestamp);
        else
            orderForm.setEndTime(timestamp);
        orderFormImpl.updateOrderForm(orderForm);
        return new Model(1, "订单信息更新成功");
    }

    @CrossOrigin
    @PostMapping("/orders")
    @ApiOperation(value = "生成订单", notes = "清除购物车的所有商品")
    public Model createOrderByCart(@RequestBody String userName, @RequestBody Integer addressId) {
        orderFormImpl.createOrderInCart(userName, addressId);
        return new Model<>(1, "删除成功");
    }

    @CrossOrigin
    @PostMapping("/order")
    @ApiOperation(value = "立即购买并生成订单", notes = "将当前选中的物品申城订单")
    public Model createOrderByInstance(@RequestBody String userName, @RequestBody ProductDetail productDetail,
                                       @RequestBody int addressId) {
        orderFormImpl.createOrderByInstance(userName, productDetail, addressId);
        return new Model<>(1, "删除成功");
    }

    @CrossOrigin
    @GetMapping("/order/{userName}")
    @ApiOperation(value = "查询订单（简略信息）", notes = "查询到当前用户下的所有订单")
    public Model searchOrderByUserName(@PathVariable String userName) {
        if (userName == null) {
            return new Model(0, "请重新点击查询按钮");
        }
        List<OrderFormVO> orderFormVos = orderFormImpl.searchByUserName(userName);
        return new Model<>(1, "找到如下订单信息", orderFormVos);
    }
}

