package com.example.SecKillSys.po;

import com.example.SecKillSys.enums.Gender;
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
@Table(name = "Teams")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "name")
    private String name;

}
