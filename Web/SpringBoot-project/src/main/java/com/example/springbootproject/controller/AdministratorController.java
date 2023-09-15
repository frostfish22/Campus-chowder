package com.example.springbootproject.controller;

import com.example.springbootproject.entity.Administrator;
import com.example.springbootproject.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author frost
 */
@RestController
public class AdministratorController {
    @Autowired
    AdministratorService administratorService;
    @GetMapping("/administrator")
    public List<Administrator> selectAll(){
        return administratorService.selectAll();
    }
}
