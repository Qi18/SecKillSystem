package com.example.SecKillSys.service.lmpl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.SecKillSys.enums.ReturnCode;
import com.example.SecKillSys.exception.BusinessException;
import com.example.SecKillSys.repository.BuildingRepository;
import com.example.SecKillSys.repository.UserRepository;
import com.example.SecKillSys.service.AuthenticationService;
import com.example.SecKillSys.service.UserService;
import com.example.SecKillSys.vo.AuthenticationRequest;
import com.example.SecKillSys.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: rich
 * @date: 2022/10/16 10:39
 * @description:
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    UserService userService;

    @Override
    public UserVO authentication(AuthenticationRequest authenticationRequest) throws Exception {
        String username = authenticationRequest.getUsername();
        //先对用户名做非空判断
        if (StringUtils.isBlank(username)){
            throw new BusinessException(ReturnCode.BLANK_USERNAME);
        }
        //不为空则根据用户名到数据库中查找用户信息
        UserVO userVO = userService.retrieveByUsername(username);

        //存在则根据用户输入的密码和数据库取出的用户密码进行比对
        if (!userVO.getPassword().equals(authenticationRequest.getPassword())){
            throw new BusinessException(ReturnCode.WRONG_PASSWORD);
        }
        return userVO;

    }
}
