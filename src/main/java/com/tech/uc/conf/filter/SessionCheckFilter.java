package com.tech.uc.conf.filter;

import com.alibaba.fastjson.JSON;
import com.tech.uc.common.exception.SessionValidException;
import com.tech.uc.common.utils.RedisClient;
import com.tech.uc.common.utils.ResponseEntity;
import com.tech.uc.common.utils.UserContextUtil;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import static com.tech.uc.common.constant.Constant.StatusCode.SESSION_INVALID;

/**
 * @author zhuyz
 * @date 2020/4/21 0021 20:49
 * @description
 */
public class SessionCheckFilter extends UserFilter {
    private static final String DEFAULT_SESSION_KEY_PREFIX = "shiro:session:";

    public SessionCheckFilter() {
        super();
    }

    // 访问禁止时，调用该方法
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //允许跨域,不能放在postHandle内
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        res.setHeader("Access-Control-Allow-Origin", "*");
        // 状态码非200，则前台响应失败，所以需要用200状态码；后台只做数据响应给前台，不做请求的跳转
        res.setStatus(HttpServletResponse.SC_OK);
        res.setCharacterEncoding("UTF-8");
        PrintWriter writer = res.getWriter();
        writer.write(JSON.toJSONString(ResponseEntity.buildCustom("session失效，请重新登录", SESSION_INVALID)));
        // 如果前台session，后台session为空，或者不相等，则清空缓存中的session
        UserContextUtil.currentSession().setTimeout(0);
//            throw new SessionValidException("session失效，请重新登录");
        writer.flush();
        writer.close();
        return false;
    }
}
