package com.ddz.demo.dao;

import com.ddz.demo.po.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    public Integer addOrder(Order order);

    public Order getOrder(Integer userId);

    public List<Integer> getAllUserIdIfNoPrice();

    public Integer updateOrder(Order order);
}
