package com.example.SecKillSys.po;

import lombok.*;

import javax.persistence.*;

/**
 * @author: rich
 * @date: 2022/10/13 20:16
 * @description:
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "StudentAdmin")
public class StuAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

}
