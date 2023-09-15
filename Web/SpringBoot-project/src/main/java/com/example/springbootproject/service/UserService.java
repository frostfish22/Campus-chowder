package com.example.springbootproject.service;

import com.example.springbootproject.entity.User;
import com.example.springbootproject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author frost
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> selectAll(){
        return userMapper.selectList(null);
    }
}
