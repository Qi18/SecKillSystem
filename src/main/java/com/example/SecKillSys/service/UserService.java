package com.example.SecKillSys.service;


import com.example.SecKillSys.vo.UserVO;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface UserService {

    List<UserVO> findAll() throws Exception;

    UserVO findById(Integer id) throws Exception;

    /**
     * @param username: 用户名
     * @return: com.example.SecKillSys.vo.UserVO
     * @author: rich
     * @date: 2022/10/13 21:22
     * @description: 登录操作
     */
    UserVO findByUsername(String username) throws Exception;

    /**
     * @param userVO: 用户信息
     * @return: com.example.SecKillSys.vo.UserVO
     * @author: rich
     * @date: 2022/10/15 21:50
     * @description: 修改用户信息
     */
    UserVO updateUser(UserVO userVO) throws Exception;


    void addUser(UserVO userVO) throws Exception;

    void deleteUserById(Integer id) throws Exception;

}