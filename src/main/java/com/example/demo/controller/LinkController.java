package com.example.demo.controller;

import com.example.demo.entity.Link;
import com.example.demo.model.LinkModel;
import com.example.demo.model.Model;
import com.example.demo.service.LinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Api(tags = "广告管理")
@RestController
public class LinkController {
    LinkService linkService;

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @CrossOrigin
    @DeleteMapping("/Link/{id}")
    @ApiOperation(value = "删除广告", notes = "根据url的id来删除指定广告")
    public Model<Link> delete(@PathVariable String id) {
        if (id == null) {
            return new Model<>(400, "请求错误", null);
        } else if (!linkService.delete(Integer.parseInt(id))) {
            return new Model<>(500, "服务器错误", null);
        }
        return new Model<>(200, "成功", null);
    }

    @CrossOrigin
    @PostMapping("/link")
    @ApiOperation(value = "添加广告", notes = "根据link对象来创建广告")
    public Model<LinkModel> save(@RequestBody Link link) {
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        Long time = createTime.getTime();
        time = time + 1000L * 60 * 60 * 24 * 365 * 99;
        Timestamp endTime = new Timestamp(time);
        if (link == null) {
            return new Model<>(400, "请求错误", null);
        }
        link.setCreationTime(createTime);
        link.setEndTime(endTime);
        if (!linkService.save(link)) {
            return new Model<>(500, "服务器错误", null);
        }
        return new Model<>(200, "成功", null);
    }

    @CrossOrigin
    @GetMapping("/link")
    @ApiOperation(value = "获取广告", notes = "获取广告表中所有信息")
    public Model<List<Link>> getAll() {
        return new Model<>(200, "成功", linkService.get());
    }
}
