package com.ddz.demo.service;

import com.ddz.demo.dao.PhonecardMapper;
import com.ddz.demo.po.Phonecard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
* 表明这是一个Service层
* */
@Service
public class PhonecardService {
    @Autowired
    PhonecardMapper phonecardMapper;

    public Phonecard getPhonebyNumber(Integer number){
        return this.phonecardMapper.getPhonebyNumber(number);
    }

    public Integer updatePhonecard(Phonecard phonecard){
        return this.phonecardMapper.updatePhonecard(phonecard);
    }


}

