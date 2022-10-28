package com.example.SecKillSys.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author: rich
 * @date: 2022/10/27 19:24
 * @description:
 */

@Configuration
public class ShiroConfig {

    @Autowired
    private CustomerMD5Realm customerMD5Realm;

//    //1.创建shiroFilter  //负责拦截所有请求
//    @Bean
//    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//
//        //给filter设置安全管理器
//        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
//
//        //配置系统受限资源
//        //配置系统公共资源
//        Map<String,String> map = new HashMap<String,String>();
//        map.put("/index.jsp","authc");//authc 请求这个资源需要认证和授权
//
//        //默认认证界面路径
//        shiroFilterFactoryBean.setLoginUrl("/login.jsp");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
//
//        return shiroFilterFactoryBean;
//    }

    //2.创建安全管理器
    @Bean(name = "SecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //加密对象设置
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(3);
        //Realm对象设置加密
        customerMD5Realm.setCredentialsMatcher(hashedCredentialsMatcher);
        //安全管理器添加Realm
        defaultWebSecurityManager.setRealm(customerMD5Realm);
        return defaultWebSecurityManager;
    }


    //设置内部过滤器
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("SecurityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean subject = new ShiroFilterFactoryBean();
        //设置安全管理器
        //需要关联 securityManager ，通过参数把 securityManager 对象传递过来
        subject.setSecurityManager(securityManager);
        Map<String, String> map = new LinkedHashMap<>();
        //认证
        map.put("/user/*","authc");
        map.put("/building/*","authc");
        map.put("/login","anon");
        map.put("/register","anon");
        subject.setFilterChainDefinitionMap(map);
        //未登录页面跳转
        subject.setLoginUrl("/noLogin");
        //无权限页面跳转
        subject.setUnauthorizedUrl("/noAuth");
        return subject;
    }



//    //设置认证过滤器
//    @Bean
//    public DefaultShiroFilterChainDefinition shiroFilterChainDefinition() {
//        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
//        //设置不认证可以访问的资源
//        definition.addPathDefinition("/user/login", "anon");
//        //设置认证才可以访问的资源
//        definition.addPathDefinition("/**", "authc");
//        return definition;
//    }
}
