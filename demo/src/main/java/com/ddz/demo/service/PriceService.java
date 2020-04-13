package com.ddz.demo.service;

import com.ddz.demo.po.Price;

import java.util.List;

public interface PriceService {
    public List<Price> getAllPrice();

    public List<Price> getPriceByUserId(Integer userId);

    public Integer addPrice(Price price);
}
