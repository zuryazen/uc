package com.tech.uc.conf.filter;

import com.alibaba.fastjson.JSON;
import com.tech.uc.common.exception.SessionValidException;
import com.tech.uc.common.utils.ResponseEntity;
import com.tech.uc.common.utils.UserContextUtil;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import static com.tech.uc.common.constant.Constant.Auth.AUTHORIZATION;
import static com.tech.uc.common.constant.Constant.StatusCode.SESSION_INVALID;

/**
 * @author zhuyz
 * @date 2020/4/21 0021 20:49
 * @description
 */
public class SessionCheckFilter extends UserFilter {

    public SessionCheckFilter() {
        super();
    }


    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        res.setHeader("Access-Control-Allow-Origin", "*");
        // 浏览器的嗅探请求
        if (req.getMethod().equals("OPTIONS")) {
            res.addHeader("Access-Control-Allow-Methods", "GET,HEAD,POST,PUT,DELETE,TRACE,OPTIONS,PATCH");
            res.addHeader("Access-Control-Allow-Headers", "Content-Type, Accept, Authorization");
        }
        return super.preHandle(request, response);
    }


    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //允许跨域,不能放在postHandle内
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        res.setHeader("Access-Control-Allow-Origin", "*");
        // 浏览器的嗅探请求
        if (!req.getMethod().equals("OPTIONS")) {
//            res.addHeader("Access-Control-Allow-Methods", "GET,HEAD,POST,PUT,DELETE,TRACE,OPTIONS,PATCH");
//            res.addHeader("Access-Control-Allow-Headers", "Content-Type, Accept, Authorization");
//        } else {
            res.setStatus(HttpServletResponse.SC_OK);
            res.setCharacterEncoding("UTF-8");
            PrintWriter writer = res.getWriter();

            String sessionId = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
            String currentSessionId = UserContextUtil.currentSessionId();
            if (sessionId == null || currentSessionId == null || !sessionId.equals(currentSessionId)) {
                writer.write(JSON.toJSONString(ResponseEntity.buildCustom("session失效，请重新登录", SESSION_INVALID)));
                // 如果前台session，后台session为空，或者不相等，则清空缓存中的session
                UserContextUtil.currentSession().setTimeout(0);
//            throw new SessionValidException("session失效，请重新登录");
            } else {
                UserContextUtil.currentSession().setTimeout(1000 * 60 * 30);
            }
            writer.flush();
            writer.close();
        }

//        return false;
        return super.onAccessDenied(request, response);
    }
}
