package com.tech.uc.common.exception;

import org.apache.shiro.authc.AccountException;

/**
 * @author zhuyz
 * @date 2020/4/4 0004 15:19
 * @description sesion失效异常
 */
public class TokenValidException extends AccountException {


    public TokenValidException() {
    }

    public TokenValidException(String message) {
        super(message);
    }

    public TokenValidException(Throwable cause) {
        super(cause);
    }

    public TokenValidException(String message, Throwable cause) {
        super(message, cause);
    }
}
