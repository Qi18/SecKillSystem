package com.example.SecKillSys.controller;


import com.example.SecKillSys.vo.UserVO;
import com.example.SecKillSys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public UserVO login(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
        return userService.login(username, password);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public UserVO update(@RequestBody UserVO userVO) throws Exception {
        return userService.update(userVO);
    }



}

