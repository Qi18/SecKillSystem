package com.example.SecKillSys.vo;

import com.example.SecKillSys.enums.Gender;
import com.example.SecKillSys.po.Bed;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import java.util.List;

/**
 * @author: rich
 * @date: 2022/10/16 15:05
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomVO {

    private Integer id;

    private String name;

    private Integer nums;

    private Integer remainNums;

    private List<BedVO> beds;

    private Gender gender;
}
