package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserService myUserService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*设置授权*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*限制角色的访问权限*/
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasAnyRole("vip1")
                .antMatchers("/level2/**").hasAnyRole("vip2")
                .antMatchers("/level3/**").hasAnyRole("vip3")
                .anyRequest().authenticated();
        /*开启自动登录页面*/
        http.formLogin();
        /*定义退出页面返回的路径*/
        http.logout().logoutSuccessUrl("/");
        /*开启记住我功能*/
        http.rememberMe();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       /* auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder())
                .withUser("wanzicong").password("123456").roles("vip1", "vip2");*/
        auth.userDetailsService(myUserService);
    }
}