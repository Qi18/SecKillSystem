package com.example.SecKillSys.config;

/**
 * @author: rich
 * @date: 2022/10/27 18:58
 * @description:
 */
import com.example.SecKillSys.po.User;
import com.example.SecKillSys.repository.UserRepository;
import com.example.SecKillSys.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMD5Realm extends AuthorizingRealm {
    @Autowired
    UserRepository userRepository;

    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        // 从系统返回的身份信息集合中获取主身份信息（用户名）
//        String primaryPrincipal = (String) principals.getPrimaryPrincipal();
//        System.out.println("用户名: "+primaryPrincipal);
//
//        //根据用户名获取当前用户的角色信息,以及权限信息
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//
//        //将数据库中查询角色信息赋值给权限对象
//        simpleAuthorizationInfo.addRole("admin");
//        simpleAuthorizationInfo.addRole("user");
//
//        //将数据库中查询权限信息赋值个权限对象
//        simpleAuthorizationInfo.addStringPermission("user:*:01");
//        simpleAuthorizationInfo.addStringPermission("product:create");
//
//        return simpleAuthorizationInfo;
        return null;
    }

    // 认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取身份信息（账户）
        String principal = (String) token.getPrincipal();
        // 获取凭证信息
        User user = userRepository.findUserByUsername(principal);
        // 数据库信息
        if (user != null) {
            String realword = user.getPassword();
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                token.getPrincipal(), realword, ByteSource.Util.bytes("salt"), this.getName()
            );
            return authenticationInfo;
        }
        return null;
    }
}
