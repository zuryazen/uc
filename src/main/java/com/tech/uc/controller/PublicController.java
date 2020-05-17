package com.tech.uc.controller;

import com.tech.uc.common.exception.PwdErrorException;
import com.tech.uc.common.exception.PwdErrorManyException;
import com.tech.uc.common.exception.UserNotFoundException;
import com.tech.uc.common.utils.JwtUtils;
import com.tech.uc.common.utils.UserContextUtil;
import com.tech.uc.entity.Resource;
import com.tech.uc.entity.Role;
import com.tech.uc.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import com.tech.uc.common.utils.RedisClient;
import com.tech.uc.common.utils.ResponseEntity;
import com.tech.uc.service.UserService;
import com.tech.uc.vo.UserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.tech.uc.common.constant.Constant.Auth.*;
import static com.tech.uc.common.constant.Constant.StatusCode.*;

/**
 * @author zhuyz
 * @date 2020/4/2 0002 22:01
 * @description
 */
@RestController
@RequestMapping("/pub")
@Slf4j
public class PublicController {


    @Autowired
    private UserService userService;

    @Autowired
    private RedisClient redisClient;

    /**
     * login接口
     *
     * @param userVO
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserVO userVO, HttpServletRequest request, HttpServletResponse response) {
        String username = userVO.getUsername();
        String password = userVO.getPassword();
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("用户不存在");
        }
        // 账户冻结
        if (user.getStatus() == 0) {
            throw new LockedAccountException();
        }
        if (!getMD5SimpleHash(password).toHex().equals(user.getPassword())) {
            throw new PwdErrorException();
        }
        String userId = user.getId();
        // 生成token
        String token = JwtUtils.sign(userId, username, password);
        user.setToken(token);
        setRoleAndPermit(user);
        // 删除重复登录的用户信息
        redisClient.del(PREFIX_USER_INFO + userId);
        // 缓存新的用户信息
        redisClient.set(PREFIX_USER_INFO + userId, user, JwtUtils.EXPIRE_TIME / 1000);
        return ResponseEntity.buildSuccess(user, "登录成功");
        //        String token = (String)authenticationToken.getPrincipal();
//        String username = JwtUtils.getUsername(token);
//
//        // redis存储的错误登录用户的key
//        String failKey = PREFIX + username;
//        Integer errorLoginCount = 0;
//
//        // 从redis中获取登录错误次数
//        Object errorLogins = redisClient.get(failKey);
//        if (errorLogins != null) {
//            errorLoginCount = Integer.parseInt(errorLogins.toString());
//        }
//        // 当错误登录次数大于2时，锁定登录用户
//        if (errorLoginCount >= RETRY_NUM) {
//            // ExcessiveAttemptsException为shiro中一个可自定义的异常
//            throw new PwdErrorManyException("登录错误次数过多，账号已锁定，请等待[" + redisClient.getExpire(failKey) + "]秒");
//        }
//
//        // 使用父类继续比较登录用户是否正确
//        boolean match = super.doCredentialsMatch(authenticationToken, info);
//
//        // 如果校验密码匹配成功，则删除redis中缓存的failkey，否则对错误次数累加，并且重新设置过期时间
//        if (match) {
//            // 密码比较成功后缓存menus
//            if (errorLogins != null) {
//                redisClient.del(failKey);
//            }
//        } else {
//            redisClient.set(failKey, String.valueOf(++errorLoginCount), 60);
//            throw new PwdErrorException("登录密码错误，请重新输入，重试次数：" + (RETRY_NUM - errorLoginCount));
//        }
//
//        return match;
    }

    /**
     * 登出，清除【redis缓存的userInfo】
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/logout")
    public ResponseEntity logout(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader(AUTHORIZATION).toString();
        if (token == null) {
            ResponseEntity.buildCustom(null, LOGOUT_ERROR);
        }
        String userId = JwtUtils.getUserId(token);
        redisClient.del(PREFIX_USER_INFO + userId);
        return ResponseEntity.buildSuccess();
    }

    @PostMapping("/registry")
    public ResponseEntity registry(@RequestBody UserVO userVO) {
        User user = userService.findByUsername(userVO.getUsername());
        if (user == null) {
            user = new User(userVO.getUsername(), getMD5SimpleHash(userVO.getPassword()).toHex());
            userService.addUser(user);
            return ResponseEntity.buildSuccess();
        } else {
            return ResponseEntity.buildCustom(null, -1, "该用户已经存在");
        }
    }

    public static SimpleHash getMD5SimpleHash(String password) {
        String hashName = "MD5";
        return new SimpleHash(hashName, password, null, 2);
    }


    /**
     * 设置用户角色权限
     * @param user
     */
    private void setRoleAndPermit(User user) {
        Set<String> roleSet = user.getRoleList().stream().map(Role::getCode).collect(Collectors.toSet());
        Set<String> permitSet = user.getResourceList().stream()
                .map(Resource::getPermission)
                .filter(w -> w != null && !"".equals(w))
                .collect(Collectors.toSet());
        Map<String, Object> params = user.getParams();
        params.put("roleSet", roleSet);
        params.put("permitSet", permitSet);
    }


}
