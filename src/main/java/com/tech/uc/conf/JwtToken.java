package com.tech.uc.conf;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author zhuyz
 * @date 2020/5/7 0007 21:43
 * @description
 */
public class JwtToken implements AuthenticationToken {

    private static final long serialVersionUID = 8736584961073651994L;

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
