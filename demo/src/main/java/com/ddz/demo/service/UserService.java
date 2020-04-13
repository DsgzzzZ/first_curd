package com.ddz.demo.service;

import com.ddz.demo.po.User;

import java.util.List;

public interface UserService {

    public List<Integer> getAllUserId();

    public Integer getUserIdByNumber(String number);

    public User getUserByNumber(String number);

    public Integer addUser(User user);

}
