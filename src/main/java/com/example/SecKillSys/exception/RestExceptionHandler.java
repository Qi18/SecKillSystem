package com.example.SecKillSys.exception;

import com.example.SecKillSys.enums.ReturnCode;
import com.example.SecKillSys.response.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: rich
 * @date: 2022/10/15 12:14
 * @description:
 */

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    /**
     * @param e:
     * @return: com.example.SecKillSys.response.ResultData<java.lang.String>
     * @author: rich
     * @date: 2022/10/15 17:42
     * @description: 默认全局异常处理。
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> handleException(Exception e) {
//        log.error("全局异常信息 ex={}", e.getMessage(), e);
        return ResultData.fail(ReturnCode.RC500.getCode(),e.getMessage());
    }


    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> handleBusinessException(BusinessException e) {
//        log.error("全局异常信息 ex={}", e.getMessage(), e);
        return ResultData.fail(e.getCode(),e.getMessage());
    }
}
