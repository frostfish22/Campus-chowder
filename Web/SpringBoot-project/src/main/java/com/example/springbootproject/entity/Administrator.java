package com.example.springbootproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author frost
 * {@code @massage}  对应administrator表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrator {
    private int id;
    private String name;
    private String password;
    private String email;
    private String phone;
}
