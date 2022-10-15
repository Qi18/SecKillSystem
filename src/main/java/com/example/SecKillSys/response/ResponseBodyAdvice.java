package com.example.SecKillSys.response;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.lang.Nullable;

/**
 * @author: rich
 * @date: 2022/10/15 12:06
 * @description:
 */


public interface ResponseBodyAdvice<T> {
    /**
     * 是否支持advice功能
     * true 支持，false 不支持
     */
    boolean supports(MethodParameter var1, Class<? extends HttpMessageConverter<?>> var2);

    /**
     * 对返回的数据进行处理
     */
    @Nullable
    T beforeBodyWrite(@Nullable T var1, MethodParameter var2, MediaType var3, Class<? extends HttpMessageConverter<?>> var4, ServerHttpRequest var5, ServerHttpResponse var6);
}
