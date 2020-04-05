package com.tech.uc.common.exception;

import org.apache.shiro.authc.AccountException;

/**
 * @author zhuyz
 * @date 2020/4/4 0004 15:19
 * @description 账号密码错误异常
 */
public class PwdErrorException extends AccountException {


    public PwdErrorException() {
    }

    public PwdErrorException(String message) {
        super(message);
    }

    public PwdErrorException(Throwable cause) {
        super(cause);
    }

    public PwdErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
