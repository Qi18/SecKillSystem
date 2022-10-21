package com.example.SecKillSys.vo;

import com.example.SecKillSys.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author: rich
 * @date: 2022/10/21 20:02
 * @description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GroupVO {

    private Integer id;

    private Gender gender;

    private Integer name;

    private List<UserVO> userVOS;
}
