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
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author: rich
 * @date: 2022/10/15 12:08
 * @description:
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    /*
     * @return: java.lang.Object
     * @author: rich
     * @date: 2022/10/15 17:41
     * @description: 在返回前端之前的处理，包括生成同一格式的JSON
     */
    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, org.springframework.http.server.ServerHttpRequest request, org.springframework.http.server.ServerHttpResponse response) {
        if(body instanceof String){
            return objectMapper.writeValueAsString(ResultData.success(body));
        }
        if(body instanceof ResultData){
            return body;
        }
        return ResultData.success(body);
    }
}