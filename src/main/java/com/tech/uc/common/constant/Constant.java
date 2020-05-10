package com.tech.uc.common.constant;

public class Constant {

    // 状态码
    public static class StatusCode {

        public static final Integer UNKNOWN_ERROR = -1;
        // 客户端请求成功
        public static final Integer OK = 200;
        // redirect到其它的页面
        public static final Integer OTHER = 300;
        // 请求的资源并无更改
        public static final Integer NOT_MODIFIED  = 304;
        // 错误请求
        public static final Integer BAD_REQUEST = 400;
        // 请求未经授权
        public static final Integer UNAUTHORIZED = 401;
        // 服务器收到请求，但是拒绝提供服务
        public static final Integer FORBIDDEN = 403;
        // 请求资源不存在
        public static final Integer NOT_FOUND = 404;
        // 登录失败
        public static final Integer LOGIN_ERROR = 405;
        // 服务器发生不可预期的错误,排查服务端的日志
        public static final Integer INTERNAL_SERVER_ERROR = 500;
        // 服务器当前不能处理客户端的请求
        public static final Integer SERVER_UNAVAILABLE = 503;
        // 用户失效
        public static final Integer USER_INVALID = 601;
        // 未登录
        public static final Integer NO_LOGIN = 602;
        // token失效
        public static final Integer TOKEN_INVALID = 603;
        // 更新失败
        public static final Integer UPDATE_ERROR = 604;
        // 刪除失败
        public static final Integer DELETE_ERROR = 605;
        // 请求用户不存在
        public static final Integer USER_NOT_FOUND = 606;
        // 密码错误
        public static final Integer PASSWORD_ERROR = 607;
        // 错误登录次数过多
        public static final Integer LOGIN_ERR_TOO_LONG = 608;
        // 账号被锁
        public static final Integer USER_LOCK = 609;
        // 退出登录失败
        public static final Integer LOGOUT_ERROR = 610;
        // 无权访问
        public static final Integer NO_PERMISSION = 611;

    }

    public static class Auth {
        public static final String AUTHORIZATION = "Authorization";

        public static final String PREFIX_USER_TOKEN = "userToken:";

        public static final String PREFIX_USER_INFO = "userInfo:";

        public static final String AUTHORIZATIONINFO = "authorizationinfo";


    }




}
