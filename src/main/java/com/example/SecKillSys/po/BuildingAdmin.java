package com.example.SecKillSys.po;

import lombok.*;

import javax.persistence.*;

/**
 * @author: rich
 * @date: 2022/10/13 20:16
 * @description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "BuildingAdmin")
public class BuildingAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "building_id")
    private String building_id;

}
