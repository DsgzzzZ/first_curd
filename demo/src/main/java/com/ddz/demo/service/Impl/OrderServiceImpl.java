package com.ddz.demo.service.Impl;

import com.ddz.demo.dao.OrderMapper;
import com.ddz.demo.po.Order;
import com.ddz.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public Integer addOrder(Order order) {
        return this.orderMapper.addOrder(order);
    }

    @Override
    public Order getOrder(Integer userId) {
        return this.orderMapper.getOrder(userId);
    }

    @Override
    public List<Integer> getAllUserIdIfNoPrice(){
        return this.orderMapper.getAllUserIdIfNoPrice();
    }

    @Override
    public Integer updateOrder(Order order){
        return this.orderMapper.updateOrder(order);
    }
}
