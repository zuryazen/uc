package com.tech.uc.controller;

import com.tech.uc.common.exception.PwdErrorException;
import com.tech.uc.common.exception.PwdErrorManyException;
import com.tech.uc.common.exception.UserNotFoundException;
import com.tech.uc.common.utils.JwtUtils;
import com.tech.uc.common.utils.UserContextUtil;
import com.tech.uc.conf.CustomSessionManager;
import com.tech.uc.entity.User;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.subject.support.WebDelegatingSubject;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import com.tech.uc.common.utils.RedisClient;
import com.tech.uc.common.utils.ResponseEntity;
import com.tech.uc.service.UserService;
import com.tech.uc.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.tech.uc.common.constant.Constant.Auth.AUTHORIZATION;
import static com.tech.uc.common.constant.Constant.Auth.PREFIX_USER_TOKEN;
import static com.tech.uc.common.constant.Constant.StatusCode.*;

/**
 * @author zhuyz
 * @date 2020/4/2 0002 22:01
 * @description
 */
@RestController
@RequestMapping("/pub")
public class PublicController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PublicController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RedisClient redisClient;

    /**
     * login接口
     * @param userVO
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserVO userVO, HttpServletRequest request, HttpServletResponse response) {
        Subject subject = SecurityUtils.getSubject();
        Map<String, Object> info = new HashMap<>();
        try {
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
            String hashName = "MD5";
            SimpleHash hash = new SimpleHash(hashName, password, null, 2);
            if(!hash.toHex().equals(user.getPassword())){
               throw new PwdErrorException();
            }
            redisClient.set(username, user);
            // 生成token
            String token = JwtUtils.sign(username, password);
            redisClient.set(PREFIX_USER_TOKEN + token, token,JwtUtils.EXPIRE_TIME / 1000);
            info.put("token", token);
            info.put("user", user);
            return ResponseEntity.buildSuccess(info, "登录成功");
        } catch (UserNotFoundException e) {
            LOGGER.error(userVO.getUsername() + "登录失败，用户不存在", e);
            return ResponseEntity.buildCustom(e.getMessage(), USER_NOT_FOUND);
        } catch (LockedAccountException e) {
            LOGGER.error(userVO.getUsername() + "登录失败，账号被锁", e);
            return ResponseEntity.buildCustom(e.getMessage(), USER_LOCK);
        } catch (PwdErrorException e) {
            LOGGER.error(userVO.getUsername() + "登录失败，密码错误", e);
            return ResponseEntity.buildCustom(e.getMessage(), PASSWORD_ERROR);
        } catch (PwdErrorManyException e) {
            LOGGER.error(userVO.getUsername() + "登录失败，错误登录次数过多，账号被锁定", e);
            return ResponseEntity.buildCustom(e.getMessage(), LOGIN_ERR_TOO_LONG);
        } catch (Exception e) {
            LOGGER.error(userVO.getUsername() + "登录失败，未知错误", e);
            return ResponseEntity.buildCustom(e.getMessage(), UNKNOWN_ERROR);
        }
    }

    @GetMapping("/logout")
    public ResponseEntity logout(HttpServletRequest request, HttpServletResponse response) {
        UserContextUtil.currentSubject().logout();
        return ResponseEntity.buildSuccess();
    }

}
