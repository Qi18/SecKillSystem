package com.example.SecKillSys.controller;


import com.example.SecKillSys.po.User;
import com.example.SecKillSys.response.AjaxResult;
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
    public AjaxResult update(@RequestBody UserVO userVO) throws Exception {
        AjaxResult ajax = AjaxResult.success();
        ajax.put(AjaxResult.DATA_TAG, userService.updateUser(userVO));
        return ajax;
    }

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public AjaxResult findAll() throws Exception {
        AjaxResult ajax = AjaxResult.success();
        ajax.put(AjaxResult.DATA_TAG, userService.retrieveAllUsers());
        return ajax;
    }

    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public AjaxResult find(@RequestParam("user_id") Integer user_id) throws Exception {
        AjaxResult ajax = AjaxResult.success();
        ajax.put(AjaxResult.DATA_TAG, userService.retrieveUserDetails(user_id));
        return ajax;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public AjaxResult delete(@RequestParam Integer id) throws Exception {
        userService.deleteUserById(id);
        return AjaxResult.success("删除成功");
    }

    @RequestMapping(value = "/add",method = RequestMethod.PUT)
    public AjaxResult add(@RequestBody UserVO userVO) throws Exception {
        userService.addUser(userVO);
        return AjaxResult.success("添加成功");
    }






}

