package com.tech.uc.conf.filter;

import com.alibaba.fastjson.JSON;
import com.tech.uc.common.utils.JwtUtils;
import com.tech.uc.common.utils.RedisClient;
import com.tech.uc.common.utils.ResponseEntity;
import com.tech.uc.conf.JwtToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static com.tech.uc.common.constant.Constant.Auth.*;
import static com.tech.uc.common.constant.Constant.StatusCode.TOKEN_INVALID;

/**
 * @author zhuyz
 * @date 2020/5/7 0007 21:50
 * @description
 */
@Slf4j
public class JwtFilter extends BasicHttpAuthenticationFilter {

    private static final String loginUrl = "/pub/login";
    private static final String registryUri = "/api/pub/registry";

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Autowired
    private RedisClient redisClient;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();


    @Override
    public String getLoginUrl() {
        return contextPath + loginUrl;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        log.info("JwtFilter-->>>isAccessAllowed-Method:init()");
        HttpServletRequest req = (HttpServletRequest) request;
        if(antPathMatcher.match(getLoginUrl(), req.getRequestURI()) || antPathMatcher.match(registryUri, req.getRequestURI())){
            return true;
        }
        try {
            return executeLogin(request, response);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 执行登录操作
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        log.info("JwtFilter-->>>executeLogin-Method:init()");
        JwtToken jwtToken = jwtToken(request);
        // 提交给realm进行登入,如果错误他会抛出异常并被捕获, 反之则代表登入成功,返回true
        getSubject(request, response).login(jwtToken);
        // token认证成功刷新缓存失效时间
        String token = jwtToken.getToken();
        String userId = JwtUtils.getUserId(token);
        redisClient.expire(PREFIX_USER_INFO + userId, JwtUtils.EXPIRE_TIME / 1000);
        return true;
    }

    /**
     * 访问拒绝时的处理方法
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        response500(request, response);
        return false;
    }

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


    /**
     * 拒绝访问时返回的响应结果集
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void response500(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        // 状态码非200，则前台响应失败，所以需要用200状态码；后台只做数据响应给前台，不做请求的跳转
        res.setStatus(HttpStatus.OK.value());
        res.setCharacterEncoding("UTF-8");
        PrintWriter writer = res.getWriter();
        writer.write(JSON.toJSONString(ResponseEntity.buildCustom("token失效或者未登录，请重新登录", TOKEN_INVALID)));
        writer.flush();
        writer.close();
    }

    /**
     * 根据request生成jwtToken对象
     *
     * @param request
     * @return
     */
    private JwtToken jwtToken(ServletRequest request) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader(AUTHORIZATION);//Access-Token
        JwtToken jwtToken = new JwtToken(token);
        return jwtToken;
    }


}
