package com.example.SecKillSys.enums;

/**
 * @author: rich
 * @date: 2022/10/15 12:10
 * @description:
 */
public enum ReturnCode {
    /**操作成功**/
    RC200(200, "操作成功"),
    /**服务异常**/
    RC500(500,"系统异常，请稍后重试"),

    BLANK_USERNAME(1001,"用户名不能为空"),
    NO_SUCH_USER(1002,"用户未注册"),
    WRONG_PASSWORD(1003, "密码错误，请重试");
    /**自定义状态码**/
    private final int code;
    /**自定义描述**/
    private final String message;

    ReturnCode(int code, String message){
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
