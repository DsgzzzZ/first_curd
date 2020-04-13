package com.ddz.demo.service.Impl;

import com.ddz.demo.dao.PriceMapper;
import com.ddz.demo.po.Price;
import com.ddz.demo.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    PriceMapper priceMapper;

    @Override
    public List<Price> getAllPrice() {
        return this.priceMapper.getAllPrice();
    }

    @Override
    public List<Price> getPriceByUserId(Integer userId) {
        return this.priceMapper.getPriceByUserId(userId);
    }

    @Override
    public Integer addPrice(Price price) {
        return this.priceMapper.addPrice(price);
    }


}
