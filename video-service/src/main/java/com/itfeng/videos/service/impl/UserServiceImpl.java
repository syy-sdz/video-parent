package com.itfeng.videos.service.impl;

import com.itfeng.videos.mapper.UserMapper;
import com.itfeng.videos.pojo.User;
import com.itfeng.videos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByEmailAndPassword(User user) {
        return userMapper.selectUserByEmailAndPassword(user);
    }

    @Override
    public User selectUserByEmail(String email) {
        return userMapper.selectUserByEmail(email);
    }

    @Override
    public Boolean insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public Boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
