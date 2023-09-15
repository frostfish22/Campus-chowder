package com.example.springbootproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootproject.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author frost
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
