package com.example.SecKillSys.service;

import com.example.SecKillSys.vo.AuthenticationRequest;
import com.example.SecKillSys.vo.UserVO;

/**
 * @author: rich
 * @date: 2022/10/16 10:39
 * @description:
 */
public interface AuthenticationService {

    /**
     * @param authenticationRequest: 用户名和密码
     * @return: com.example.SecKillSys.vo.UserVO
     * @author: rich
     * @date: 2022/10/16 11:59
     * @description: 认证方法
     */
    UserVO authentication(AuthenticationRequest authenticationRequest) throws Exception;

}
