package com.zn.springbootmall.service;

import com.zn.springbootmall.dto.UserLoginRequest;
import com.zn.springbootmall.dto.UserRegisterRequest;
import com.zn.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);
}
