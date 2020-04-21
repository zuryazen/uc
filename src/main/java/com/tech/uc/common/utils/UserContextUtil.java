package com.tech.uc.common.utils;

import com.tech.uc.entity.Org;
import com.tech.uc.entity.Resource;
import com.tech.uc.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import java.util.List;
import java.util.Map;

/**
 * @author zhuyz
 * @date 2020/4/19 0019 21:27
 * @description 持有认证用户信息类
 */
public class UserContextUtil {


    private UserContextUtil() {}

    /**
     * 当前session
     * @return
     */
    public static Session currentSession() {
        return SecurityUtils.getSubject().getSession();
    }


    /**
     * 当前运行服务器
     * @return
     */
    public static String currentServer() {
        return (String) SecurityUtils.getSubject().getSession().getAttribute("serverName");
    }


    /**
     * 当前项目ip address
     * @return
     */
    public static String currentIpAddress() {
        return (String) SecurityUtils.getSubject().getSession().getAttribute("ipAddress");
    }

    /**
     * 当前项目baseURL
     * @return
     */
    public static String currentBaseURL() {
        return (String) SecurityUtils.getSubject().getSession().getAttribute("baseURL");
    }

    /**
     * 设置当前项目baseURL
     * @return
     */
    public static void setCurrentBaseURL(String baseURL) {
        SecurityUtils.getSubject().getSession().setAttribute("baseURL", baseURL);
    }

    /**
     * 当前用户menus
     * @return
     */
    public static List<Resource> currentMenus() {
        return (List<Resource>) SecurityUtils.getSubject().getSession().getAttribute("menus");
    }

    /**
     * 设置当前用户menus
     * @return
     */
    public static void setCurrentMenus(List<Resource> menus) {
        SecurityUtils.getSubject().getSession().setAttribute("menus", menus);
    }

    /**
     * 当前用户sessionId
     * @return
     */
    public static String currentSessionId() {
        return (String) SecurityUtils.getSubject().getSession().getId();
    }


    /**
     * 当前登录用户
     * @return
     */
    public static User currentUser() {
        Object o = SecurityUtils.getSubject().getPrincipal();

        if (o instanceof User) {
            return (User) o;
        }

        return (User) SecurityUtils.getSubject().getSession().getAttribute("user");
    }

    /**
     * 当前登录用户名
     * @return
     */
    public static String username() {
        return currentUser().getUsername();
    }

    /**
     * 当前登录用户ID
     * @return
     */
    public static String userId() {
        return currentUser().getId();
    }

    /**
     * 当前登录用户姓名
     * @return
     */
    public static String fullName() {
        return currentUser().getFullName();
    }

    /**
     * 获取当前登录用户所属组织（多个组织取第一组织）
     */
    public static Org org() {
        return currentUser().getOrgList().get(0);
    }

    /**
     * 获取当前登录用户所属组织（可能存在多个组织）
     * @return
     */
    public static List<Org> orgList() {
        return currentUser().getOrgList();
    }

    /**
     * 获取当前登录用户所属组织ID（多个组织取第一组织）
     */
    public static String orgId() {
        return org().getId();
    }

    /**
     * 为map新增当前用户信息参数
     * @param params
     * 新增参数如下：
     *
     *  curUserId,
     *  curFullName,
     *  curOrgId
     */
    public static void addCurrentUser(Map<String, Object> params) {
        params.put("curUserId", userId());
        params.put("curFullName", fullName());
        params.put("curOrgId", orgId());
    }

}
