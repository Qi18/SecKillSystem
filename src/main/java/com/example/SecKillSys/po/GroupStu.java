package com.example.SecKillSys.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author: rich
 * @date: 2022/10/21 19:39
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Group_Stu")
public class GroupStu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "group_id")
    private Integer gid;

    @Column(name = "stu_number")
    private String sNum;


}
