package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    /**
     * 用户登录 成功返回true 失败返回 false
     * @param user
     * @return boolean
     */
    boolean userLogin(User user);

    /**
     * 用户注册
     * @param user
     * @return
     */
    boolean userRegister(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    boolean changeInfo(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    boolean deleteUser(User user);
    /**
     * 为管理使用的查询用户信息
     * @param user
     * @return
     */
    User searchUserByManger(User manager, User user);

    /**
     * 为用户自己使用的查询用户信息
     * @param user
     * @return
     */
    User searchUser(User user);
}
