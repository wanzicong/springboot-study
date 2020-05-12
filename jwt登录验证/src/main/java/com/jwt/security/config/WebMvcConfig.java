package com.jwt.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/*注册拦截器的配置*/
@Configuration
public class WebMvcConfig  extends WebMvcConfigurationSupport {

    /*添加拦截器*/


    /*注册拦截器*/
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

    }
}
