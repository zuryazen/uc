package com.tech.uc.conf;

import com.tech.uc.common.exception.UserNotFoundException;
import com.tech.uc.common.utils.JwtUtils;
import com.tech.uc.common.utils.RedisClient;
import com.tech.uc.common.utils.UserContextUtil;
import com.tech.uc.entity.Resource;
import com.tech.uc.entity.Role;
import com.tech.uc.entity.User;
import com.tech.uc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

import static com.tech.uc.common.constant.Constant.Auth.AUTHORIZATIONINFO;
import static com.tech.uc.common.constant.Constant.Auth.PREFIX_USER_INFO;

/**
 * @author zhuyz
 * @date 2020/4/1 0001 23:24
 * @description 自定义realm
 */
@Slf4j
public class JwtRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;

    @Autowired
    private RedisClient redisClient;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 重写授权获取方法
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            return null;
        }
        AuthorizationInfo info = null;
        User user = (User) principals.fromRealm(getName()).stream().findFirst().get();
        info = (AuthorizationInfo) redisClient.get(AUTHORIZATIONINFO + user.getId());
        if (info == null) {
            // Call template method if the info was not found in a cache
            info = doGetAuthorizationInfo(principals);
        }
        return info;
    }

    /**
     * 授权,进行权限校验的时候回调
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权-----doGetAuthorizationInfo");
        User user = (User) principals.fromRealm(getName()).stream().findFirst().get();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(user.getRoleList().stream().map(Role:: getCode).collect(Collectors.toSet()));
        authorizationInfo.setStringPermissions(user.getResourceList().stream()
                .map(Resource:: getPermission)
                .filter(w -> w != null && !"".equals(w))
                .collect(Collectors.toSet()));
        redisClient.set(AUTHORIZATIONINFO + user.getId(), authorizationInfo, JwtUtils.EXPIRE_TIME / 1000);
        return authorizationInfo;
    }

    /**
     * 登录认证
     * @param authenticationToken 用户登录输入的信息
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("登录认证begin----doGetAuthenticationInfo");
        String token = (String)authenticationToken.getPrincipal();
        String userId = JwtUtils.getUserId(token);
        String username = JwtUtils.getUsername(token);
        User user = (User)redisClient.get(PREFIX_USER_INFO + userId);
        if (user == null) {
            user = userService.findByUsername(username);
        }
        if (user == null) {
            throw new UserNotFoundException("用户不存在");
        }
        // 账户冻结
        if (user.getStatus() == 0) {
            throw new LockedAccountException();
        }
        System.out.println("登录认证end----doGetAuthenticationInfo");
        return new SimpleAuthenticationInfo(user, token, getName());
    }














}
