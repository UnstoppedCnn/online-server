package com.example.demo.controller;

import com.example.demo.entity.Address;
import com.example.demo.model.Model;
import com.example.demo.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "地址管理")
@RestController
public class AddressController {

    AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @CrossOrigin
    @GetMapping("/address/{id}")
    @ApiOperation(value = "获取用户地址", notes = "根据url的id来获取指定用户收货地址信息")
    public Model<List<Address>> getAll(@PathVariable String id) {
        if (id == null) {
            return new Model<>(400, "请求错误");
        }
        if (!addressService.select(Integer.parseInt(id))) {
            return new Model<>(404, "没有地址信息");
        }
        return new Model<>(200, "成功", addressService.get(Integer.parseInt(id)));
    }

    @CrossOrigin
    @PutMapping("/address/{id}")
    @ApiOperation(value = "更新用户地址", notes = "更新地址信息")
    public Model<Address> update(@RequestBody Address address) {
        if (address == null) {
            return new Model<>(400, "请求错误");
        }
        if (!addressService.update(address)) {
            return new Model<>(500, "更新失败");
        }
        return new Model<>(200, "成功");
    }

    @CrossOrigin
    @PostMapping("/address")
    @ApiOperation(value = "添加地址", notes = "添加用户的地址")
    public Model<Address> save(@RequestBody Address address) {
        if (address == null) {
            return new Model<>(400, "请求错误");
        } else if (!addressService.save(address)) {
            return new Model<>(500, "请求参数错误");
        }
        addressService.save(address);
        return new Model<>(200, "成功");
    }

    @CrossOrigin
    @DeleteMapping("/address/{id}")
    @ApiOperation(value = "删除地址", notes = "根据url的addressId来删除指定地址")
    public Model<Address> delete(@PathVariable String id) {
        if (id == null) {
            return new Model<>(400, "请求错误");
        }
        if (!addressService.delete(Integer.parseInt(id))) {
            return new Model<>(500, "删除失败");
        }
        return new Model<>(200, "成功");
    }
}
