package com.zn.springbootmall.service;

import com.zn.springbootmall.dto.CreateOrderRequest;
import com.zn.springbootmall.dto.OrderQueryParams;
import com.zn.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
