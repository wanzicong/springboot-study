package com.jwt;

import com.jwt.security.util.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JwtApplication {
    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
    }
    /*注册bean对象*/
    @Bean
    public JwtUtil getJwt(){
        return  new JwtUtil();
    }
}
