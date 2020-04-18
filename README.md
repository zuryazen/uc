# admin_user
admin_user( this contains vue &amp; elementUI &amp; springboo and so on)

##1.get/set方法严格按照  getXXX() /  setXXX() --->否则转换为json数据时会有字段名称不对的问题

##2.热部署  会导致类加载器的不同，导致同类型cast错误

##3.shiro整合redis持久化session时遇到的问题
####参考：https://www.cnblogs.com/hafiz/p/7247005.html
3.1.shiro的DefaultWebSessionManager类中，默认Cookie名称是JSESSIONID，
这样的话与servlet容器名冲突, 如jetty, tomcat等默认JSESSIONID,
当跳出shiro servlet时如error-page容器会为JSESSIONID重新分配值导致登录会话丢失!

3.2.解决方案：
在shiroConfig的sessionManager配置中按照下列顺序配置，重写simpleCookie的name以及path 
customSessionManager.setSessionDAO(redisSessionDAO());
customSessionManager.setSessionIdCookie(simpleCookie());