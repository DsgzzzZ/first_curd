package com.ddz.demo.service.Impl;

import com.ddz.demo.dao.UserMapper;
import com.ddz.demo.po.User;
import com.ddz.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<Integer> getAllUserId(){
        return this.userMapper.getAllUserId();
    }

    @Override
    public Integer getUserIdByNumber(String number) {
        return this.userMapper.getUserIdByNumber(number);
    }

    @Override
    public User getUserByNumber(String number){
        return this.userMapper.getUserByNumber(number);
    }

    @Override
    public Integer addUser(User user) {
        return this.userMapper.addUser(user);
    }
}
