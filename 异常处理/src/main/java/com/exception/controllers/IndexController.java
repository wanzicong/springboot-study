package com.exception.controllers;

import com.exception.exception.CustomizeException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @RequestMapping("/")
    public  String index(){
        return  "index";
    }
    @RequestMapping("/test")
    public String test(){
        throw  new CustomizeException("我是自定义的异常类");
    }
}
