package com.tech.uc.common.exception;

import com.tech.uc.common.utils.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.tech.uc.common.constant.Constant.StatusCode.*;

/**
 * 1.声明异常处理器
 * 2.对异常统一处理
 *
 * @author zhuyz
 * @date 2020/5/9 0009 10:21
 * @description 自定义公共异常处理
 */
@RestControllerAdvice
@Slf4j
public class BaseExceptionHandler {

    /**
     * 权限异常捕获
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler(value = AuthorizationException.class)
    public ResponseEntity errorAuthorizationException(HttpServletRequest request, HttpServletResponse response, Exception e) {
        if (e instanceof UnauthorizedException) {
            return ResponseEntity.buildCustom("no permission", NO_PERMISSION);
        }
        return ResponseEntity.buildCustom(null, UNKNOWN_ERROR, "未知错误");
    }

    /**
     * 用户主体异常捕获
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler(value = AccountException.class)
    public ResponseEntity errorAccountException(HttpServletRequest request, HttpServletResponse response, Exception e) {
        if (e instanceof UserNotFoundException) {
            log.error("登录失败，用户不存在", e);
            return ResponseEntity.buildCustom(null, USER_NOT_FOUND, "登录失败，用户不存在");
        }
        if (e instanceof LockedAccountException) {
            log.error("登录失败，账号被锁", e);
            return ResponseEntity.buildCustom(null, USER_LOCK, "登录失败，账号被锁");
        }
        if (e instanceof PwdErrorException) {
            log.error("登录失败，密码错误", e);
            return ResponseEntity.buildCustom(null, PASSWORD_ERROR, "登录失败，密码错误");
        }
        if (e instanceof PwdErrorManyException) {
            log.error("登录失败，错误登录次数过多，账号被锁定", e);
            return ResponseEntity.buildCustom(null, LOGIN_ERR_TOO_LONG, "登录失败，错误登录次数过多，账号被锁定");
        }

        log.error("登录失败，未知错误", e);
        return ResponseEntity.buildCustom(null, UNKNOWN_ERROR, "登录失败，未知错误");
    }

}
