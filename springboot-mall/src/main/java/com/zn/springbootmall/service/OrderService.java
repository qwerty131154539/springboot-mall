package com.zn.springbootmall.service;

import com.zn.springbootmall.dto.CreateOrderRequest;
import com.zn.springbootmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
