package com.tech.uc.conf;

import com.tech.uc.common.exception.PwdErrorException;
import com.tech.uc.common.exception.PwdErrorManyException;
import com.tech.uc.common.utils.JwtUtils;
import com.tech.uc.common.utils.RedisClient;
import com.tech.uc.common.utils.UserContextUtil;
import com.tech.uc.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;

import static com.tech.uc.common.constant.Constant.Auth.PREFIX_USER_INFO;
import static com.tech.uc.common.constant.Constant.Auth.PREFIX_USER_TOKEN;

/**
 * @author zhuyz
 * @date 2020/4/4 0004 14:30
 * @description 自定义登录比较器
 */
@Slf4j
public class JwtMatcher extends HashedCredentialsMatcher {

    //这个是redis里的key的统一前缀
    private static final String PREFIX  = "USER_LOGIN_FAIL:";
    // 登录重试次数
    private static final Integer RETRY_NUM = 3;


    @Autowired
    private RedisClient redisClient;

    /**
     * 自定义校验登录
     * @param authenticationToken
     * @param info
     * @return
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo info) {
        log.info("Begin to doCredentialsMatch");
        String token = (String)authenticationToken.getCredentials();
        User user = (User) info.getPrincipals().getPrimaryPrincipal();
        String cacheToken = user.getToken();
        log.info("doCredentialsMatch result: " + (cacheToken != null));
        return cacheToken != null && cacheToken.equals(token);
    }
}
