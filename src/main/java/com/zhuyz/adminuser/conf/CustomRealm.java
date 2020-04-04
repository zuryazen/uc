package com.zhuyz.adminuser.conf;

import com.zhuyz.adminuser.common.exception.PwdErrorException;
import com.zhuyz.adminuser.common.exception.UserNotFoundException;
import com.zhuyz.adminuser.entity.Permission;
import com.zhuyz.adminuser.entity.User;
import com.zhuyz.adminuser.service.IRoleService;
import com.zhuyz.adminuser.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import sun.security.acl.PermissionImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhuyz
 * @date 2020/4/1 0001 23:24
 * @description 自定义realm
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;


    /**
     * 授权,进行权限校验的时候回调
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权-----doGetAuthorizationInfo");
        User newUser = (User)principals.getPrimaryPrincipal();
        User user = userService.findAllUserInfoByUsername(newUser.getName());
        List<String> roleStrList;
        List<String> permissionStrList = new ArrayList<>();
        // TODO: 逻辑不够严谨，待改造
        roleStrList = user.getRoleList().stream().map(role -> {
                    permissionStrList.addAll(role.getPermissionList().stream()
                            .map(Permission::getName)
                            .filter(permission -> permission != null && !"".equals(permission))
                            .collect(Collectors.toList()));
                    return role.getName();
                }).collect(Collectors.toList());

        System.out.println("roleStrList: " + roleStrList);
        System.out.println("permissionStrList: " + permissionStrList);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roleStrList);
        simpleAuthorizationInfo.addStringPermissions(permissionStrList);

        return simpleAuthorizationInfo;
    }

    /**
     * 登录认证
     * @param token 用户登录输入的信息
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("登录认证----doGetAuthenticationInfo");
        String username = (String)token.getPrincipal();
        User user = userService.findUserByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("用户不存在");
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());

    }














}
