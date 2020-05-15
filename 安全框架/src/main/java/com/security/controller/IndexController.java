package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {
    /* 定义页面跳转的前缀*/
    private final String PREFIX = "pages/";

    /*  欢迎页面*/
    @GetMapping("/")
    public String index() {
        return "welcome";
    }

    /* 登录页面*/
    @GetMapping("/userLogin")
    public String loginPage() {
        return PREFIX + "login";
    }

    /*  返回级别为一的页面*/
    @GetMapping("/level1/{path}")
    public String level1(@PathVariable("path") String path) {
        return PREFIX + "level1/" + path;
    }

    /* 返回级别为二的页面*/
    @GetMapping("/level2/{path}")
    public String level2(@PathVariable("path") String path) {
        return PREFIX + "level2/" + path;
    }

    /* 返回级别为三的页面*/
    @GetMapping("/level3/{path}")
    public String level3(@PathVariable("path") String path) {
        return PREFIX + "level3/" + path;
    }

}
