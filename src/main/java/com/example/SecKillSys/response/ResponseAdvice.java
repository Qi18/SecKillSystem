package com.example.SecKillSys.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: rich
 * @date: 2022/10/15 12:08
 * @description:
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
//    @Autowired
//    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        System.out.println("1");
        return true;
    }
    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
//        if(o instanceof String){
//            return objectMapper.writeValueAsString(ResultData.success(o));
//        }
        System.out.println("1");
        if(o instanceof ResultData){
            return o;
        }
        return ResultData.success(o);
    }
}