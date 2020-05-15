package com.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /*设置授权*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*限制角色的访问权限*/
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
        /*开启自动登录页面*/
        http.formLogin();
        /*定义退出页面返回的路径*/
        http.logout().logoutSuccessUrl("/");
        /*开启记住我功能*/
        http.rememberMe();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*将每个用户绑定上角色 = 他们既可以访问特定的页面*/
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder())
                .withUser("wanzicong").password("123456").roles("vip1", "vip2")
                .and()
                .withUser("mayun").password("123456").roles("vip2", "vip3")
                .and()
                .withUser("liuqiandong").password("123456").roles("vip3", "vip1");

//        auth.jdbcAuthentication();
    }
}
