package com.example.SecKillSys.vo;

import lombok.Data;

import java.util.List;

/**
 * @author: rich
 * @date: 2022/10/16 12:01
 * @description:
 */
@Data
public class BuildingVO {

    private Integer id;

    private String name;

    private List<RoomVO> rooms;

    private Integer remainNums;

    private Integer nums;
}
