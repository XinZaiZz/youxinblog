package com.youxin.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author youxin
 * @program youxinblog
 * @description shiro配置类
 * @date 2022-02-08 22:08
 */
@Configuration
public class ShiroConfig {

    //第三步，ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加shiro的内置过滤器
        /*
         * anon : 无需认证就可以访问
         * authc : 必须认证了才让访问
         * user : 必须拥有记住我功能才能使用
         * perms : 必须拥有对某个资源的权限才能访问
         * role : 必须拥有某个角色权限才能访问
         * */
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//        filterChainDefinitionMap.put("/static/**","anon");
        filterChainDefinitionMap.put("/article/toArticleWritePage","perms[user:author]");

        //其他资源都需要认证  authc 表示需要认证才能进行访问 user表示配置记住我或认证通过可以访问的地址
        filterChainDefinitionMap.put("/index", "anon");
//        filterChainDefinitionMap.put("/*","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        //设置拦截成功后的登陆请求
        shiroFilterFactoryBean.setLoginUrl("/unAuthorized");
        //设置授权认证失败请求
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuthorized");
        return shiroFilterFactoryBean;
    }

    //第二步，DefaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSercurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //第一步，创建realm对象
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    //整合shiroDialect:用来整合shiro thymeleaf
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
