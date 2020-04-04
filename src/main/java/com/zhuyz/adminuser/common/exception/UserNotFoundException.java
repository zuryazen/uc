package com.zhuyz.adminuser.common.exception;

import org.apache.shiro.authc.AccountException;

/**
 * @author zhuyz
 * @date 2020/4/4 0004 15:21
 * @description 用户不存在异常
 */
public class UserNotFoundException extends AccountException {


    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
