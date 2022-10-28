package com.example.SecKillSys.controller;

import com.example.SecKillSys.service.UserService;
import com.example.SecKillSys.vo.UserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: rich
 * @date: 2022/10/28 14:20
 * @description:
 */

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
        //获取subject对象
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            return "登录成功";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "登录失败";
        }
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestBody UserVO userVO) throws Exception {
        if (userVO.getUsername() == null) throw new Exception("用户名不能为空");
        if (userVO.getPassword() == null) throw new Exception("密码不能为空");
        Md5Hash md5Hash = new Md5Hash(userVO.getPassword(), "salt", 3);
        userVO.setPassword(md5Hash.toString());
        userService.addUser(userVO);
        return "注册成功";
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public String logout(HttpServletRequest httpServletRequest){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "已经退出登录";
    }

    @RequestMapping("/noAuth")
    public String noAuth(){
        return "未授权不能访问";
    }

    @RequestMapping("/noLogin")
    public String noLogin(){
        return "未登录不能访问";
    }
}


