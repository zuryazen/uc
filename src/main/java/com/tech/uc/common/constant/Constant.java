package com.tech.uc.common.constant;

public class Constant {

    // 状态码
    public static class StatusCode {

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
        // session失效
        public static final Integer SESSION_INVALID = 603;
    }

    public static class Auth {
        public static final String AUTHORIZATION = "Authorization";
        public static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";
    }




}
