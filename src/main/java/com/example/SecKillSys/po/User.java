package com.example.SecKillSys.po;


import com.example.SecKillSys.enums.Gender;
import com.example.SecKillSys.enums.UserType;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "tag")
    private String tag;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "ID_number")
    private String iNum;

    @Column(name = "phone")
    private String phone;

    @Column(name = "student_number")
    private String sNum;

    @Column(name = "name")
    private String name;

    @Column(name = "usertype")
    private UserType userType;

}

