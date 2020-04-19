package com.tech.uc.controller;

import com.tech.uc.common.exception.PwdErrorException;
import com.tech.uc.common.exception.PwdErrorManyException;
import com.tech.uc.common.exception.UserNotFoundException;
import com.tech.uc.common.utils.UserContextUtil;
import com.tech.uc.conf.CustomSessionManager;
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

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.tech.uc.common.constant.Constant.Auth.AUTHORIZATION;
import static com.tech.uc.common.constant.Constant.StatusCode.*;

/**
 * @author zhuyz
 * @date 2020/4/2 0002 22:01
 * @description
 */
@RestController
@RequestMapping("/pub")
public class PublicController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisClient redisClient;

    @Autowired
    private RedisSessionDAO redisSessionDAO;


    private static final Logger LOGGER = LoggerFactory.getLogger(PublicController.class);

    @GetMapping("/need_login")
    public ResponseEntity needLogin() {
        return ResponseEntity.buildCustom("温馨提示，未登录，请先登录", NO_LOGIN);
    }

    @GetMapping("/not_permit")
    public ResponseEntity noPermit() {
        return ResponseEntity.buildError("温馨提示：拒绝访问，没有权限");
    }


    @GetMapping("/index")
    public ResponseEntity index() {
        ArrayList<Object> videoList = new ArrayList<>();
        videoList.add("java从入门到放弃");
        videoList.add("python从入门到放弃");
        videoList.add("redis从入门到放弃");
        videoList.add("zookeeper从入门到放弃");
        videoList.add("springcloud从入门到放弃");
        return ResponseEntity.buildSuccess(videoList);
    }

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
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userVO.getUsername(),
                    userVO.getPassword());
            String requestURL = request.getRequestURL().toString();
            String requestURI = request.getRequestURI();
            requestURL = requestURL.replaceAll(requestURI, "");
            UserContextUtil.setCurrentBaseURL(requestURL);
            subject.login(usernamePasswordToken);
            info.put("sessionId", UserContextUtil.currentSessionId());
            info.put("menus", UserContextUtil.currentMenus());
            return ResponseEntity.buildSuccess(info, "登录成功");
        }catch (UserNotFoundException e) {
            LOGGER.error(userVO.getUsername() + "登录失败，用户不存在", e);
            return ResponseEntity.buildError(e.getMessage());
        }catch (PwdErrorException e) {
            LOGGER.error(userVO.getUsername() + "登录失败，密码错误", e);
            return ResponseEntity.buildError(e.getMessage());
        }catch (PwdErrorManyException e) {
            LOGGER.error(userVO.getUsername() + "登录失败，错误登录次数过多，账号被锁定", e);
            return ResponseEntity.buildError(e.getMessage());
        }catch (Exception e) {
            LOGGER.error(userVO.getUsername() + "登录失败，未知错误", e);
            return ResponseEntity.buildError(e.getMessage());
        }

    }


    @GetMapping("/checkToken")
    public ResponseEntity checkToken() {
        Subject subject = SecurityUtils.getSubject();
        if (subject == null) {
            return ResponseEntity.buildCustom("USER_INVALID", USER_INVALID);
        }

//        if (redisClient.get() > 0) {
//            return ResponseEntity.buildCustom("USER_NO_INVALID", OK);
//        }



        return null;



    }





}
