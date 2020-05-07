package com.tech.uc.conf;

import com.tech.uc.conf.filter.CustomRolesOrAuthorizationFilter;
import com.tech.uc.conf.filter.JwtFilter;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AuthenticationStrategy;
import org.apache.shiro.authc.pam.FirstSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SessionStorageEvaluator;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    public CustomRolesOrAuthorizationFilter customRolesOrAuthorizationFilter() {
        return new CustomRolesOrAuthorizationFilter();
    }

    /**
     * 交由 Spring 来自动地管理 Shiro-Bean 的生命周期
     */
    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();

    }
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

    /**
     * 不向 Spring容器中注册 JwtFilter Bean，防止 Spring 将 JwtFilter 注册为全局过滤器
     * 全局过滤器会对所有请求进行拦截，而本例中只需要拦截除 /login 和 /logout 外的请求
     * 另一种简单做法是：直接去掉 jwtFilter()上的 @Bean 注解
     */
    @Bean
    public FilterRegistrationBean<Filter> registration(JwtFilter filter) {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<Filter>(filter);
        registration.setEnabled(false);
        return registration;
    }

    @Bean
    public JwtFilter jwtFilter() {
        return new JwtFilter();

    }
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        LOGGER.info("执行shiroFilterFactoryBean.shiroFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 设置securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 前后分离不适用:需要登录的接口，如果需要访问某个接口，如果没有登录，则会跳转到此接口(如果不是前后端分离，则跳转页面)
         shiroFilterFactoryBean.setLoginUrl("/pub/login");
        // 前后分离不适用:设置登录成功的跳转页面，如果前后端分离则无此选项,
        // shiroFilterFactoryBean.setSuccessUrl("/index");
        // 没有权限访问时 跳转的页面，如果前后端分离则无此选项
        // shiroFilterFactoryBean.setUnauthorizedUrl("/pub/not_permit");

        // 设置自定义filter
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("roleOrFilter", customRolesOrAuthorizationFilter());
        filterMap.put("jwt", jwtFilter());
        shiroFilterFactoryBean.setFilters(filterMap);

        // 拦截器路径，注意：一定是LinkedHashMap，因为它是有序的
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//        filterChainDefinitionMap.put("/", "anon");
        // swagger放行
//        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
//        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
//        filterChainDefinitionMap.put("/v2/**", "anon");
//        filterChainDefinitionMap.put("/webjars/**", "anon");
//        filterChainDefinitionMap.put("/configuration/security", "anon");
//        filterChainDefinitionMap.put("/configuration/ui", "anon");
//        // 匿名可访问路径
//        filterChainDefinitionMap.put("/pub/**", "anon");
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
        filterChainDefinitionMap.put("/**", "jwt");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        LOGGER.info("Shiro拦截器工厂类注入成功");
        return shiroFilterFactoryBean;
    }
    /**
     * 配置 ModularRealmAuthenticator
     */
    @Bean
    public ModularRealmAuthenticator authenticator() {
        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
        // 设置多 Realm的认证策略，默认 AtLeastOneSuccessfulStrategy
        AuthenticationStrategy strategy = new FirstSuccessfulStrategy();
        authenticator.setAuthenticationStrategy(strategy);
        return authenticator;
    }

    /**
     * 禁用session, 不保存用户登录状态。保证每次请求都重新认证
     */
    @Bean
    protected SessionStorageEvaluator sessionStorageEvaluator() {
        DefaultSessionStorageEvaluator sessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        sessionStorageEvaluator.setSessionStorageEnabled(false);
        return sessionStorageEvaluator;
    }

    /**
     * 自定义realm
     * @return
     */
    @Bean
    public JwtRealm jwtRealm() {
        JwtRealm jwtRealm = new JwtRealm();
        jwtRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return jwtRealm;
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

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        // 使用自定义cacheManager
        securityManager.setCacheManager(redisCacheManager());
        // 设置realm(推荐放到最后，不然某些情况不会生效)
        // 1.Authenticator
        securityManager.setAuthenticator(authenticator());

        // 2.Realm
        List<Realm> realms = new ArrayList<>(16);
        realms.add(jwtRealm());
//        realms.add(shiroRealm());
        securityManager.setRealms(realms);
        // 3.关闭shiro自带的session
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        subjectDAO.setSessionStorageEvaluator(sessionStorageEvaluator());
        securityManager.setSubjectDAO(subjectDAO);

        return securityManager;
    }







































}
