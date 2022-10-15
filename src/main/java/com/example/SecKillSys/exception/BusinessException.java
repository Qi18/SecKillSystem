package com.example.SecKillSys.exception;

import com.example.SecKillSys.enums.ReturnCode;

/**
 * @author: rich
 * @date: 2022/10/15 21:25
 * @description:
 */
public class BusinessException extends RuntimeException{
    /**
     * 返回code
     */
    private Integer code;
    /**
     * 返回msg
     */
    private String message;

    public BusinessException(ReturnCode returnCode) {
        super(returnCode.getMessage());
        this.code = returnCode.getCode();
    }

    public Integer getCode() {
        return code;
    }

}
