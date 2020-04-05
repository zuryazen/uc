package com.tech.uc.conf;

import com.tech.uc.common.exception.PwdErrorException;
import com.tech.uc.common.exception.PwdErrorManyException;
import com.tech.uc.common.utils.RedisClient;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhuyz
 * @date 2020/4/4 0004 14:30
 * @description 自定义登录比较器
 */
public class CustomMatcher extends HashedCredentialsMatcher {

    //这个是redis里的key的统一前缀
    private static final String PREFIX  = "USER_LOGIN_FAIL:";
    // 登录重试次数
    private static final Integer RETRY_NUM = 3;


    @Autowired
    private RedisClient redisClient;

    /**
     * 自定义校验登录
     * @param token
     * @param info
     * @return
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        String username = usernamePasswordToken.getUsername();

        // redis存储的错误登录用户的key
        String failKey = PREFIX + username;
        Integer errorLoginCount = 0;

        // 从redis中获取登录错误次数
        Object errorLogins = redisClient.get(failKey);
        if (errorLogins != null) {
            errorLoginCount = Integer.parseInt(errorLogins.toString());
        }
        // 当错误登录次数大于2时，锁定登录用户
        if (errorLoginCount >= RETRY_NUM) {
            // ExcessiveAttemptsException为shiro中一个可自定义的异常
            throw new PwdErrorManyException("登录错误次数过多，账号已锁定，请等待[" + redisClient.getExpire(failKey) + "]秒");
        }

        // 使用父类继续比较登录用户是否正确
        boolean match = super.doCredentialsMatch(token, info);

        // 如果校验密码匹配成功，则删除redis中缓存的failkey，否则对错误次数累加，并且重新设置过期时间
        if (match) {
            if (errorLogins != null) {
                redisClient.del(failKey);
            }
        } else {
            redisClient.set(failKey, String.valueOf(++errorLoginCount), 60);
            throw new PwdErrorException("登录密码错误，请重新输入，重试次数：" + (RETRY_NUM - errorLoginCount));
        }

        return match;
    }
}
