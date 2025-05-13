package com.zn.springbootmall.service;

import com.zn.springbootmall.dto.CreateOrderRequest;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
