package com.jwt.security.config;

import com.jwt.security.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/*注册拦截器的配置*/
@Configuration
public class WebMvcConfig  extends WebMvcConfigurationSupport {

    /*添加拦截器*/
    @Autowired
    JwtInterceptor jwtInterceptor;
    /*注册拦截器*/
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                /*添加需要拦截器拦截的资源*/
                .addPathPatterns("/**")
                /*排除不需要拦截的资源,如登录*/
                .excludePathPatterns("/**/login");
    }
}
