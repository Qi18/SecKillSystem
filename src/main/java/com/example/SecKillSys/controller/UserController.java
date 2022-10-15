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
    @ResponseBody
    public UserVO login(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
        UserVO userVO = userService.login(username, password);
        //TODO
        if (userVO == null) return null;
        return userVO;
    }




}

