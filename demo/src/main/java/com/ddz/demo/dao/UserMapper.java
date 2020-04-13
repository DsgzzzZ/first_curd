package com.ddz.demo.dao;

import com.ddz.demo.po.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    public List<Integer> getAllUserId();

    public Integer getUserIdByNumber(String number);

    public User getUserByNumber(String number);

    public Integer addUser(User user);
}
