package com.tech.uc.conf.filter;

import com.tech.uc.common.utils.RedisClient;
import com.tech.uc.conf.JwtToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.tech.uc.common.constant.Constant.Auth.AUTHORIZATION;
import static com.tech.uc.common.constant.Constant.Auth.PREFIX_USER_TOKEN;

/**
 * @author zhuyz
 * @date 2020/5/7 0007 21:50
 * @description
 */
@Slf4j
public class JwtFilter extends BasicHttpAuthenticationFilter {

    @Autowired
    private RedisClient redisClient;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        log.info("JwtFilter-->>>preHandle-Method:init()");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        log.info("JwtFilter-->>>isAccessAllowed-Method:init()");
        //如果请求头不存在token,则可能是执行登陆操作或是游客状态访问,直接返回true
        if (isLoginAttempt(request, response)) {
            return true;
        }
        //如果存在,则进入executeLogin方法执行登入,检查token 是否正确
        try {
            executeLogin(request, response);
            return true;
        } catch (Exception e) {
            throw new AuthenticationException("Token失效请重新登录");
        }
    }

    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        log.info("JwtFilter-->>>isLoginAttempt-Method:init()");
        HttpServletRequest req = (HttpServletRequest) request;
        if(antPathMatcher.match("/api/pub/login",req.getRequestURI())){
            return true;
        }
        String token = req.getHeader(AUTHORIZATION);
        if (token == null) {
            return false;
        }
        Object o = redisClient.get(PREFIX_USER_TOKEN + token);
        if(ObjectUtils.isEmpty(o)){
            return false;
        }
        log.info("JwtFilter-->>>isLoginAttempt-Method:返回true");
        return true;
    }


    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        log.info("JwtFilter-->>>executeLogin-Method:init()");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader(AUTHORIZATION);//Access-Token
        JwtToken jwtToken = new JwtToken(token);
        // 提交给realm进行登入,如果错误他会抛出异常并被捕获, 反之则代表登入成功,返回true
        getSubject(request, response).login(jwtToken);return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return super.onAccessDenied(request, response);
    }



}
