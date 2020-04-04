package com.zhuyz.adminuser.common.exception;

import org.apache.shiro.authc.AccountException;

/**
 * @author zhuyz
 * @date 2020/4/4 0004 15:25
 * @description 错误登录次数过多
 */
public class PwdErrorManyException extends AccountException {


    public PwdErrorManyException() {
    }

    public PwdErrorManyException(String message) {
        super(message);
    }

    public PwdErrorManyException(Throwable cause) {
        super(cause);
    }

    public PwdErrorManyException(String message, Throwable cause) {
        super(message, cause);
    }
}
