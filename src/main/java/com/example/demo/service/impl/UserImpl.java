package com.example.demo.service.impl;

import com.example.demo.dao.ProductDetailMapper;
import com.example.demo.entity.User;
import com.example.demo.dao.CartMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private ProductDetailMapper productDetailMapper;
    @Resource
    private CartMapper cartMapper;
    @Override
    public boolean userLogin(User user) {
        User user1 = userMapper.searchById(user.getUserId());
        boolean value = false;
        if (user1.getUserId() != null) {
            value = user.getPassword() == user1.getPassword();
        }
        return value;
    }

    @Override
    public boolean userRegister(User user) {
        User user1 = userMapper.searchById(user.getUserId());
        boolean value=false;
        if(user1!=null){
            return false;
        }
        value =userMapper.add(user);
        return value;
    }

    @Override
    public boolean changeInfo(User user) {
        boolean value=false;
        User user1=userMapper.searchById(user.getUserId());
        if(user1.getUserId()==null){
            return false;
        }
        value = userMapper.update(user);
        return value;
    }

    @Override
    public boolean deleteUser(User user) {
        boolean value=userMapper.delete(user);
        return value;
    }

    @Override
    public User searchUserByManger(User manager, User user) {
        User user1 = userMapper.searchById(manager.getUserId());
        if(user1.getStatus()==0)
            return null;
        user1 = userMapper.searchById(user.getUserId());
        return user1;
    }

    @Override
    public User searchUser(User user) {
        if (user == null)
            return null;
        User user1 = userMapper.searchById(user.getUserId());
        return user1;
    }

    @Override
    public List<User> getAll() {
        List<User> users = userMapper.getAll();
        return users;
    }

    @Override
    public User searchUserByPwdAndUname(User user) {
        User user1 = userMapper.searchByNameAndPwd(user);
        return user1;
    }
}
