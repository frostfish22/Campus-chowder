package com.example.springbootproject.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors() //开启跨域请求
                .and()
                .csrf()
                .disable()//禁用CSRF保护
                .authorizeRequests()
                .antMatchers("/**")
                .permitAll();//允许所有请求访问我们的资源
    }
}