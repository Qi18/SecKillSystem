package com.example.SecKillSys.vo;

import com.example.SecKillSys.po.Bed;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

/**
 * @author: rich
 * @date: 2022/10/16 15:05
 * @description:
 */
@Data
public class RoomVO {

    private Integer id;

    private String name;

    private Integer nums;

    private Integer remainNums;

    private Integer lid;

    private List<BedVO> beds;
}
