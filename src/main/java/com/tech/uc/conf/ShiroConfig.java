package com.tech.uc.conf;

import com.tech.uc.conf.filter.CustomRolesOrAuthorizationFilter;
import com.tech.uc.conf.filter.SessionCheckFilter;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.tech.uc.common.constant.Constant.Auth.AUTHORIZATION;

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
        shiroFilterFactoryBean.setLoginUrl("/pub/login");
        // 设置登录成功的跳转页面，如果前后端分离则无此选项
//        shiroFilterFactoryBean.setSuccessUrl("/index");

        // 没有权限访问时 跳转的页面，如果前后端分离则无此选项
//        shiroFilterFactoryBean.setUnauthorizedUrl("/pub/not_permit");

        // 设置自定义filter
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("sessionCheck", new SessionCheckFilter());
        filterMap.put("roleOrFilter", new CustomRolesOrAuthorizationFilter());
        shiroFilterFactoryBean.setFilters(filterMap);

        // 拦截器路径，注意：一定是LinkedHashMap，因为它是有序的
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();


//        filterChainDefinitionMap.put("/", "anon");
        // swagger放行
        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
        filterChainDefinitionMap.put("/v2/**", "anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/configuration/security", "anon");
        filterChainDefinitionMap.put("/configuration/ui", "anon");

//        filterChainDefinitionMap.put("/logout", "logout");
        // 匿名可访问路径
        filterChainDefinitionMap.put("/pub/**", "anon");
//        filterChainDefinitionMap.put("/user/**", "anon");
//
//        // 登录用户才可以访问的
//        filterChainDefinitionMap.put("/authc/**", "authc");
//
//        // admin权限可访问
//        filterChainDefinitionMap.put("/admin/**", "roleOrFilter[admin, root]");
//
//        // editor权限可访问
//        filterChainDefinitionMap.put("/video/update", "perms[video_update]");
//
//        // authc：url定义必须通过认证才可以访问
//        // anon： url可以匿名访问
//        filterChainDefinitionMap.put("/**", "authc");



        filterChainDefinitionMap.put("/**", "anon");
        filterChainDefinitionMap.put("/**", "sessionCheck");

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
        securityManager.setCacheManager(redisCacheManager());

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
        //取消登陆跳转URL后面的jsessionid参数
//        customSessionManager.setSessionIdUrlRewritingEnabled(false);
        // 1.超时时间，默认：30min，会话超时；传参为毫秒
        // 此项配置会影响SecurityUtils.getSubject().getPrincipal();
        // 因为用户登录之后会把用户信息存储在session中
         customSessionManager.setGlobalSessionTimeout(1000 * 60 * 30);
        // 2.配置session持久化
        customSessionManager.setSessionDAO(redisSessionDAO());
        // 3.此项一定要放在2的后面才会生效
        customSessionManager.setSessionIdCookie(simpleCookie());
        // 按顺序
        customSessionManager.setSessionIdCookieEnabled(true);
        customSessionManager.setSessionIdUrlRewritingEnabled(true);
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
    @Bean
    public RedisCacheManager redisCacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        // 设置过期时间，单位是秒
        redisCacheManager.setExpire(60 * 30);
        return redisCacheManager;
    }

    /**
     * 使用的是shiro-redis开源插件 session持久化
     * @return
     */
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        // 自定义redis缓存session的key名称
//        redisSessionDAO.setKeyPrefix("");
        redisSessionDAO.setRedisManager(redisManager());
        // 自定义sessionId生成策略
        redisSessionDAO.setSessionIdGenerator(sessionIdGenerator());
        return redisSessionDAO;
    }

    /**
     * 自定义sessionId生成策略
     * @return
     */
    @Bean
    public SessionIdGenerator sessionIdGenerator() {
        return new CustomSesisonIdGenerator();
    }

    @Bean
    public SimpleCookie simpleCookie() {
        // cookie的name,对应的默认是 JSESSIONID
        SimpleCookie cookie = new SimpleCookie("SHARE_JSESSIONID");
        cookie.setHttpOnly(true);
        //  path为 / 用于多个系统共享 JSESSIONID
        cookie.setPath("/");
        return cookie;
    }
//    /**
//     * Shiro生命周期处理器
//     * @return
//     */
//    @Bean
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }

    /**
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }








































}
