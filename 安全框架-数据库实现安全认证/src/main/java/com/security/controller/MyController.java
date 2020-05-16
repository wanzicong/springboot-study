package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    private final String PATH = "pages/";

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /*  返回级别为一的页面*/
    @GetMapping("/level1/{path}")
    public String level1(@PathVariable("path") String path) {
        return PATH + "level1/" + path;
    }

    /* 返回级别为二的页面*/
    @GetMapping("/level2/{path}")
    public String level2(@PathVariable("path") String path) {
        return PATH + "level2/" + path;
    }

    /* 返回级别为三的页面*/
    @GetMapping("/level3/{path}")
    public String level3(@PathVariable("path") String path) {
        return PATH + "level3/" + path;
    }
}
