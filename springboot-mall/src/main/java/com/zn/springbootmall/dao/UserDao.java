package com.zn.springbootmall.dao;

import com.zn.springbootmall.dto.UserRegisterRequest;
import com.zn.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    User getUserByEmail(String email);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}
