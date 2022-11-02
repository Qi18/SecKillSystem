package com.example.SecKillSys.exception;

import com.example.SecKillSys.enums.ReturnCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author: rich
 * @date: 2022/10/29 9:13
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalException extends RuntimeException{

    private ReturnCode returnCode;
}
