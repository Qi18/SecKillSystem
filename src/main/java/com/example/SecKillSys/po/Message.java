package com.example.SecKillSys.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: rich
 * @date: 2022/11/2 15:40
 * @description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {
    private Integer groupID;
    private Integer buildID;
}
