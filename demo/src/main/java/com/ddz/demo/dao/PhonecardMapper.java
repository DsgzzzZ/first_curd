package com.ddz.demo.dao;

import com.ddz.demo.po.Phonecard;
import org.springframework.stereotype.Repository;

/*
* 声明此类是一个Mapper
* */
@Repository
public interface PhonecardMapper {
    Phonecard getPhonebyNumber(Integer number);

    int updatePhonecard(Phonecard phonecard);
}
