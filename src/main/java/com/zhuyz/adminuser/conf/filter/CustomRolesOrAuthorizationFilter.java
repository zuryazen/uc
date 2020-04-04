package com.zhuyz.adminuser.conf.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author zhuyz
 * @date 2020/4/3 0003 23:18
 * @description 自定义filter
 */
public class CustomRolesOrAuthorizationFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        Subject subject = getSubject(request, response);
        // 获取当前访问路径所需要的角色集合
        String[] rolesArray = (String[]) mappedValue;
        // 没有角色限制，可以直接访问
        if (rolesArray == null || rolesArray.length == 0) {
            //no roles specified, so nothing to check - allow access.
            return true;
        }

        List<String> roleList = Arrays.asList(rolesArray);
        // 当前subject是roleList中的任意一个，则有权访问
        // 如果当前用户满足访问路径的其中一个角色就返回true
        for (String role : roleList) {
            if (subject.hasRole(role)) {
                return true;
            }
        }
        return false;
    }
}
