package com.example.SecKillSys.vo;

import com.example.SecKillSys.enums.UserType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserVO {

    private Integer id;

    private String name;

    private String password;

    private String tag;

    private Boolean gender;

    private String ID_number;

    private String phone;

    private String student_number;

    private UserType userType;

}

