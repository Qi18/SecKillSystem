package com.example.SecKillSys.controller;


import com.example.SecKillSys.service.AuthenticationService;
import com.example.SecKillSys.vo.AuthenticationRequest;
import com.example.SecKillSys.vo.UserVO;
import com.example.SecKillSys.service.UserService;
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

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(AuthenticationRequest authenticationRequest, HttpServletRequest httpServletRequest) throws Exception {
        UserVO userVO = authenticationService.authentication(authenticationRequest);
        //获取session对象
        HttpSession session = httpServletRequest.getSession();
        //将用户的信息放入到session中
        session.setAttribute(UserVO.USER_SESSION_KEY, userVO);
        //设置session失效时间，单位为秒
        session.setMaxInactiveInterval(60);
        return "登录成功";
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public String logout(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        session.removeAttribute(UserVO.USER_SESSION_KEY);
        return "登出成功";
    }


    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public UserVO update(@RequestBody UserVO userVO) throws Exception {
        return userService.updateUser(userVO);
    }

    @RequestMapping(value = "findAll",method = RequestMethod.GET)
    public List<UserVO> findAll() throws Exception {
        return userService.findAll();
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

