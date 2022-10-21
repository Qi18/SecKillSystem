package com.example.SecKillSys.vo;

import com.example.SecKillSys.enums.Gender;
import com.example.SecKillSys.enums.UserType;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserVO {

    public static final String USER_SESSION_KEY = "user_session_key";

    private Integer id;

    private String username;

    private String password;

    private String tag;

    private Gender gender;

    private String iNum;

    private String phone;

    private String sNum;

    private UserType userType;

    private String name;

}

