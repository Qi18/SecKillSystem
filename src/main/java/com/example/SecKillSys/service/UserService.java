package com.example.SecKillSys.service;


import com.example.SecKillSys.vo.UserVO;

public interface UserService {

    /**
     * @param username: 用户名
     * @param password: 密码
     * @return: com.example.SecKillSys.vo.UserVO
     * @author: rich
     * @date: 2022/10/13 21:22
     * @description: 登录操作
     */
    UserVO login(String username, String password) throws Exception;

}