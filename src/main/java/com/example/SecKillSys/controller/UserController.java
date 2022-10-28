package com.example.SecKillSys.controller;


import com.example.SecKillSys.service.AuthenticationService;
import com.example.SecKillSys.vo.AuthenticationRequest;
import com.example.SecKillSys.vo.UserVO;
import com.example.SecKillSys.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;


    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public UserVO update(@RequestBody UserVO userVO) throws Exception {
        return userService.updateUser(userVO);
    }

    @RequestMapping(value = "findAll",method = RequestMethod.GET)
    public List<UserVO> findAll() throws Exception {
        return userService.retrieveAllUsers();
    }

    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    public String delete(@RequestParam Integer id) throws Exception {
        userService.deleteUserById(id);
        return "删除成功";
    }

    @RequestMapping(value = "add",method = RequestMethod.PUT)
    public String add(@RequestBody UserVO userVO) throws Exception {
        userService.addUser(userVO);
        return "添加成功";
    }






}

