package com.ddz.demo.service;

import com.ddz.demo.po.Order;

import java.util.List;

public interface OrderService {
    public Integer addOrder(Order order);

    public Order getOrder(Integer userId);

    public List<Integer> getAllUserIdIfNoPrice();

    public Integer updateOrder(Order order);

}
