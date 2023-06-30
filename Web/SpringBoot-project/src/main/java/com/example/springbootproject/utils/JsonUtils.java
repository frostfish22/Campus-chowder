package com.example.springbootproject.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JsonUtils {

    private final ObjectMapper objectMapper;

    @Autowired
    public JsonUtils(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * 将Java对象转换为JSON字符串
     *
     * @param obj Java对象
     * @return JSON字符串
     * @throws JsonProcessingException
     */
    public String toJsonString(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    /**
     * 将JSON字符串转换为Java对象
     *
     * @param jsonString JSON字符串
     * @param clazz      Java类
     * @param <T>        泛型参数
     * @return Java对象
     * @throws JsonProcessingException
     */
    public <T> T toJavaObject(String jsonString, Class<T> clazz) throws JsonProcessingException {
        return objectMapper.readValue(jsonString, clazz);
    }
}