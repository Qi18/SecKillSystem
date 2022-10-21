package com.example.SecKillSys.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author: rich
 * @date: 2022/10/16 12:01
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BuildingVO {

    private Integer id;

    private String name;

    private List<RoomVO> rooms;

    private Integer remainNums;

    private Integer nums;
}
