package com.example.springbootproject.controller;

import com.example.springbootproject.entity.User;
import com.example.springbootproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author frost
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/user")
    public List<User> selectAll(){
        return userService.selectAll();
    }
}
