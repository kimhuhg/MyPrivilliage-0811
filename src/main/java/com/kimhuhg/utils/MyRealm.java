package com.kimhuhg.utils;

import com.kimhuhg.pojo.Priviliage;
import com.kimhuhg.pojo.Role;
import com.kimhuhg.pojo.Users;
import com.kimhuhg.service.IPriviliageService;
import com.kimhuhg.service.IRoleService;
import com.kimhuhg.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by kimhuhg@163.com on 2017/8/12.
 */
public class MyRealm extends AuthorizingRealm {

    @Resource(name = "roleServiceImpl")
    private IRoleService roleServiceImpl;
    @Resource(name = "userServiceImpl")
    private IUserService userServiceImpl;

    @Resource(name = "priviliageServiceImpl")
    private IPriviliageService priviliageServiceImpl;


    // 为当前登陆成功的用户授予权限和角色，已经登陆成功了
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal(); //获取用户名
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Users loginUsers = new Users();
        loginUsers.setLoginname(username);
        Users users = userServiceImpl.login(loginUsers);
        List<Role> roles = roleServiceImpl.getRoleByUsername(users.getUserid());
        HashSet<String> roleSet = new HashSet<>();
        roleSet.add(roles.get(0).getRoleEn());
        authorizationInfo.setRoles(roleSet);

        List<Priviliage> privilliageList = priviliageServiceImpl.findPriByRoleid(roles.get(0).getRoleid());
        HashSet<String> privilliageSet = new HashSet<>();
        for (Priviliage priviliage : privilliageList) {
            privilliageSet.add(priviliage.getPriUrl());
        }

        authorizationInfo.setStringPermissions(privilliageSet);
        return authorizationInfo;
    }

    // 验证当前登录的用户，获取认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal(); // 获取用户名
        Users loginUsers = new Users();
        loginUsers.setLoginname(username);
        Users users = userServiceImpl.login(loginUsers);
        if(users != null) {
            //此步验证密码
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(users.getLoginname(), users.getLoginpwd(), "myRealm");
            return authcInfo;
        } else {
            return null;
        }
    }
}
