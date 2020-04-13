package com.ddz.demo.dao;

import com.ddz.demo.po.Price;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceMapper {
    public List<Price> getAllPrice();

    public List<Price> getPriceByUserId(Integer userId);

    public Integer addPrice(Price price);
}
