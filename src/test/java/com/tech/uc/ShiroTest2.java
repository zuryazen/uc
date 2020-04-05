package com.tech.uc;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zhuyz
 * @date 2020/4/1 0001 21:33
 * @description
 */
public class ShiroTest2 {


    private SimpleAccountRealm accountRealm = new SimpleAccountRealm();

    private DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();


    @Before
    public void init() {
        accountRealm.addAccount("zhuyzAdmin", "123456", "root", "admin");
        accountRealm.addAccount("zhuyz", "666666", "user");

        defaultSecurityManager.setRealm(accountRealm);
    }


    @Test
    public void testAuthentication() {
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        // 获取当前主体 application user
        Subject subject = SecurityUtils.getSubject();
        // 构造用户
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhuyzAdmin", "123456");
        subject.login(usernamePasswordToken);

        System.out.println("认证结果: " + subject.isAuthenticated());
        System.out.println("权限root： " + subject.hasRole("root"));
        System.out.println("权限admin： " + subject.hasRole("admin"));
        System.out.println("权限user： " + subject.hasRole("user"));
        System.out.println("权限principal： " + subject.getPrincipal());
        System.out.println("权限principal2： " + subject.getPrincipals());



    }


















}
