package com.zn.springbootmall.service.impl;

import com.zn.springbootmall.dao.UserDao;
import com.zn.springbootmall.dto.UserRegisterRequest;
import com.zn.springbootmall.model.User;
import com.zn.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }
}
