package com.example.springbootproject.service;

import com.example.springbootproject.entity.Administrator;
import com.example.springbootproject.mapper.AdministratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author frost
 */
@Service
public class AdministratorService {
    @Autowired
    AdministratorMapper administratorMapper;
    public List<Administrator> selectAll(){
        return administratorMapper.selectList(null);
    }
}
