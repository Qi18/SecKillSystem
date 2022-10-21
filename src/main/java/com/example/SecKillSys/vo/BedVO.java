package com.example.SecKillSys.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;

/**
 * @author: rich
 * @date: 2022/10/16 15:05
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BedVO {

    private Integer id;

    private String name;

    private Integer rid;

    private Integer sid;
}
