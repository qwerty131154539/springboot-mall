package com.zn.springbootmall.dao;

import com.zn.springbootmall.dto.UserRegisterRequest;
import com.zn.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}
