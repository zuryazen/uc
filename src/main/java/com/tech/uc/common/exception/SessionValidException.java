package com.tech.uc.common.exception;

import org.apache.shiro.authc.AccountException;

/**
 * @author zhuyz
 * @date 2020/4/4 0004 15:19
 * @description sesion失效异常
 */
public class SessionValidException extends AccountException {


    public SessionValidException() {
    }

    public SessionValidException(String message) {
        super(message);
    }

    public SessionValidException(Throwable cause) {
        super(cause);
    }

    public SessionValidException(String message, Throwable cause) {
        super(message, cause);
    }
}
