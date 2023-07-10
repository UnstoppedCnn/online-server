package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.model.Model;
import com.example.demo.service.impl.UserImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Api(tags = "用户管理")
@RestController
public class UserController {
    @Resource
    UserImpl userImpl;

    @CrossOrigin
    @PostMapping("/login")
    @ApiOperation(value = "用户账号信息判断", notes = "判断账号和密码的一致性，账号的可见性")
    public Model login(@RequestBody User user) {
        if (user == null)
            return new Model(-1, "重新输入");
        User user1 = userImpl.searchUserByPwdAndUname(user);
        if (!Objects.equals(user1.getPassword(), user.getPassword())) {
            return new Model(-1, "输入密码有误");
        }
        return new Model(1, "登陆成功", user1);
    }

    @CrossOrigin
    @GetMapping("/user")
    @ApiOperation(value = "获取用户信息", notes = "获取用户表中所有数据")
    public Model getAll() {
        User user = new User();
        List<User> users = userImpl.getAll();
        return new Model<>(1, "查询到用户信息", users);
    }

    @CrossOrigin
    @PostMapping("/user")
    @ApiOperation(value = "添加用户", notes = "根据user对象来创建用户")
    public Model save(@RequestBody User user) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if (user == null)
            return new Model(-1, "请输入正确的信息");
        User user1 = userImpl.searchUserByPwdAndUname(user);
        if (user1 != null)
            return new Model(-1, "该账号已经存在");
        user.setCreationTime(timestamp);
        user.setUpdateTime(timestamp);
        userImpl.userRegister(user);
        User user2 = userImpl.searchUserByPwdAndUname(user);
        return new Model(1, "注册成功，祝您有个良好的购物体验", user2.getUserId());
    }

    @CrossOrigin
    @GetMapping("/user/{id}")
    @ApiOperation(value = "查询信息", notes = "根据url的id来获取指定用户信息")
    public Model get(@PathVariable String id) {
        User temp = new User();
        temp.setUserId(Integer.parseInt(id));
        User user1 = userImpl.searchUser(temp);

        if (user1 == null)
            return new Model(0, "没有找到此用户");
        user1 = userImpl.searchUser(temp);
        return new Model(1, "找到该用户", user1);
    }

    @CrossOrigin
    @PutMapping("/user")
    @ApiOperation(value = "更新用户", notes = "根据url的id来获取更新用户信息")
    public Model update(@RequestBody User user) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if (user == null)
            return new Model(-1, "请输入正确的信息");
        User user1 = userImpl.searchUser(user);
        if (user1 == null)
            return new Model(-1, "没有找到此用户");
        user.setAuthority(user.getAuthority() != null ? user.getAuthority() : user1.getAuthority());
        user.setAnswer(user.getAnswer() != null ? user.getAnswer() : user1.getAnswer());
        user.setIntegral(user.getIntegral() != null ? user.getIntegral() : user1.getIntegral());
        user.setMail(user.getMail() != null ? user.getMail() : user1.getMail());
        user.setPassword(user.getPassword() != null ? user.getPassword() : user1.getPassword());
        user.setQuestion(user.getQuestion() != null ? user.getQuestion() : user1.getQuestion());
        user.setCreationTime(user1.getCreationTime());
        user.setUserName(user.getUserName() != null ? user.getUserName() : user1.getUserName());
        user.setStatus(user.getStatus() != null ? user.getStatus() : user1.getStatus());
        user.setSex(user.getSex() != null ? user.getSex() : user1.getSex());
        user.setTelephone(user.getTelephone() != null ? user.getTelephone() : user1.getTelephone());
        user.setRealName(user.getRealName() != null ? user.getRealName() : user1.getRealName());
        user.setUpdateTime(timestamp);
        userImpl.changeInfo(user);
        return new Model(1, "用户信息更改成功");
    }

    @CrossOrigin
    @DeleteMapping("/user/{id}")
    @ApiOperation(value = "删除用户", notes = "根据url的id来获取删除用户信息")
    public Model delete(@PathVariable String id) {
        if (id == null)
            return new Model(-1, "请输入正确的信息");
        User user = new User();
        user.setUserId(Integer.parseInt(id));
        User user1 = userImpl.searchUser(user);
        if (user1 == null)
            return new Model(-1, "没有找到此用户");
        userImpl.deleteUser(user);
        return new Model(1, "删除用户成功");
    }
}
