package com.tech.uc.conf;

import com.tech.uc.conf.filter.CustomRolesOrAuthorizationFilter;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhuyz
 * @date 2020/4/2 0002 21:04
 * @description
 */
@Configuration
public class ShiroConfig {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(ShiroConfig.class);


    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private Integer redisPort;

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        LOGGER.info("执行shiroFilterFactoryBean.shiroFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 设置securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 需要登录的接口，如果需要访问某个接口，如果没有登录，则会跳转到此接口(如果不是前后端分离，则跳转页面)
        shiroFilterFactoryBean.setLoginUrl("/pub/need_login");
        // 设置登录成功的跳转页面，如果前后端分离则无此选项
        shiroFilterFactoryBean.setSuccessUrl("/index");

        // 没有权限访问时 跳转的页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/pub/not_permit");

        // 设置自定义filter
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("roleOrFilter", new CustomRolesOrAuthorizationFilter());
        shiroFilterFactoryBean.setFilters(filterMap);

        // 拦截器路径，注意：一定是LinkedHashMap，因为它是有序的
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        filterChainDefinitionMap.put("/user/**", "anon");

        // swagger放行
        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
        filterChainDefinitionMap.put("/v2/**", "anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");

        filterChainDefinitionMap.put("/logout", "logout");
        // 匿名可访问路径
        filterChainDefinitionMap.put("/pub/**", "anon");
        // 登录用户才可以访问的
        filterChainDefinitionMap.put("/authc/**", "authc");

        // admin权限可访问
        filterChainDefinitionMap.put("/admin/**", "roleOrFilter[admin, root]");

        // editor权限可访问
        filterChainDefinitionMap.put("/video/update", "perms[video_update]");

        // authc：url定义必须通过认证才可以访问
        // anon： url可以匿名访问
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        LOGGER.info("Shiro拦截器工厂类注入成功");
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 如果不是前后台分离，则无需设置
        securityManager.setSessionManager(sessionManager());

        // 使用自定义cacheManager
        securityManager.setCacheManager(cacheManager());

        // 设置realm(推荐放到最后，不然某些情况不会生效)
        securityManager.setRealm(customRealm());

        return securityManager;
    }

    /**
     * 自定义realm
     * @return
     */
    @Bean
    public CustomRealm customRealm() {
        CustomRealm customRealm = new CustomRealm();
        customRealm.setCredentialsMatcher(hashedCredentialsMatcher());

        return customRealm;
    }

    /**
     * 密码加解密规则
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        // 使用自定义比较器
        HashedCredentialsMatcher customMatcher = new CustomMatcher();
        // 设置散列算法
        customMatcher.setHashAlgorithmName("MD5");
        // 散列次数，进行多次散列算法
        customMatcher.setHashIterations(2);
        return customMatcher;
    }

    /**
     * 自定义sessionManager
     * @return
     */
    @Bean
    public SessionManager sessionManager() {
        CustomSessionManager customSessionManager = new CustomSessionManager();
        // 超时时间，默认：30min，会话超时；传参为秒
//        customSessionManager.setGlobalSessionTimeout(20 * 1000 * 60);

        // 配置session持久化
        customSessionManager.setSessionDAO(redisSessionDAO());

        return customSessionManager;
    }


    /**
     * 配置redisManager
     * @return
     */
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(redisHost);
        redisManager.setPort(redisPort);
        LOGGER.info("redisHost: {}, redisPort: ", redisHost, redisPort);
        return redisManager;
    }

    /**
     * 配置具体cache实现类(redisCacheManager)
     * @return
     */
    public CacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        // 设置过期时间，单位是秒
        redisCacheManager.setExpire(20);
        return redisCacheManager;
    }

    /**
     * 自定义session持久化
     * @return
     */
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        // 自定义sessionId生成策略
        redisSessionDAO.setSessionIdGenerator(sessionIdGenerator());
        return redisSessionDAO;
    }

    /**
     * 自定义sessionId生成策略
     * @return
     */
    public SessionIdGenerator sessionIdGenerator() {
        return new CustomSesisonIdGenerator();
    }










































}
