package com.example.SecKillSys.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * @author: rich
 * @date: 2022/10/21 20:03
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderVO {

    private Integer id;

    private Integer bid;

    private Integer status;

    private Integer rid;

    private GroupVO groupVO;
}
