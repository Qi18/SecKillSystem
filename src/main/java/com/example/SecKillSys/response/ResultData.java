package com.example.SecKillSys.response;

import com.example.SecKillSys.enums.ReturnCode;
import lombok.Data;

import java.text.SimpleDateFormat;

/**
 * @author: rich
 * @date: 2022/10/15 12:09
 * @description:
 */
@Data
public class ResultData<T> {
    /** 结果状态 ,具体状态码参见ResultData.java*/
    private int status;
    private String message;
    private T data;
    private String timestamp ;
    public ResultData (){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        this.timestamp = df.format(System.currentTimeMillis());
    }
    public static <T> ResultData<T> success(T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(ReturnCode.RC100.getCode());
        System.out.println(resultData.message);
        resultData.setMessage(ReturnCode.RC100.getMessage());
        resultData.setData(data);
        return resultData;
    }
    public static <T> ResultData<T> fail(int code, String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(code);
        resultData.setMessage(message);
        return resultData;
    }
}