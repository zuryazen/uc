package com.zhuyz.adminuser;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zhuyz
 * @date 2020/4/1 0001 21:33
 * @description
 */
public class ShiroTest3 {



    @Before
    public void init() {

    }


    @Test
    public void testAuthentication() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("jack", "456");

        subject.login(usernamePasswordToken);

        System.out.println("认证结果: " + subject.isAuthenticated());
        System.out.println("权限root： " + subject.hasRole("root"));
        System.out.println("权限admin： " + subject.hasRole("admin"));
        System.out.println("权限user： " + subject.hasRole("user"));
        System.out.println("权限principal： " + subject.getPrincipal());
        System.out.println("权限principal2： " + subject.getPrincipals());


    }


















}
