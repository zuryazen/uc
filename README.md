# uc
uc( this contains vue &amp; elementUI &amp; springboot &amp; shiro &amp; redis &amp; swagger and so on)

##1.get/set方法严格按照  getXXX() /  setXXX() --->否则转换为json数据时会有字段名称不对的问题
---
##2.热部署问题  
会导致类加载器的不同，导致同类型cast错误
---
##3.shiro整合redis持久化session时遇到的问题

###3.1 Cookie名称JSESSIONID重复问题

[详情参考博客](https://www.cnblogs.com/hafiz/p/7247005.html)

**3.1.1.**

shiro的DefaultWebSessionManager类中，默认Cookie名称是JSESSIONID，
这样的话与servlet容器名冲突, 如jetty, tomcat等默认JSESSIONID,
当跳出shiro servlet时如error-page容器会为JSESSIONID重新分配值导致登录会话丢失!

**3.1.2.解决方案：**

在shiroConfig的sessionManager配置中按照下列顺序配置，重写simpleCookie的name以及path 
```
customSessionManager.setSessionDAO(redisSessionDAO());
customSessionManager.setSessionIdCookie(simpleCookie());
```

###3.2 持久化session设置全局过期时间导致用户主体失效问题
超时时间，默认：30min，会话超时；传参为毫秒
此项配置会影响SecurityUtils.getSubject().getPrincipal();
因为用户登录之后会把用户信息存储在session中，该配置设置了过期时间
```
/**
     * 自定义sessionManager
     * @return
     */
    @Bean
    public SessionManager sessionManager() {
        CustomSessionManager customSessionManager = new CustomSessionManager();
        //取消登陆跳转URL后面的jsessionid参数
        // customSessionManager.setSessionIdUrlRewritingEnabled(false);
        // 1.超时时间，默认：30min，会话超时；传参为毫秒
        // !!! 此项配置会影响SecurityUtils.getSubject().getPrincipal();
        // 因为用户登录之后会把用户信息存储在session中
        customSessionManager.setGlobalSessionTimeout(1000 * 60 * 30);
        // 2.配置session持久化
        customSessionManager.setSessionDAO(redisSessionDAO());
        // 3.此项一定要放在2的后面才会生效
        customSessionManager.setSessionIdCookie(simpleCookie());
        return customSessionManager;
    }
```



###4.请求状态码
HttpServletResponse.SC_OK
HttpServletResponse下还有很多常用的状态码，可参考此类


###5.mybatis-plus配置问题
#####yml中mybatis-plus配置过后无需再配置mybatis
```
mybatis-plus:
  type-aliases-package: com.tech.uc.entity
  mapper-locations: classpath:mapper/*Mapper.xml
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: false
  global-config:
    #！！！驼峰下划线转换
    db-column-underline: true  // 全局配置，很重要，要不然数据库中带有下划线的字段值映射不到实体类中
``` 
[更多配置详情参考博客](https://www.cnblogs.com/lianggp/p/7573653.html)
