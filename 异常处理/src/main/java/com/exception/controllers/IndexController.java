package com.exception.controllers;

import com.exception.exception.CustomizeException;
import com.exception.exception.ErrorList;
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
        if (true){
            throw  new CustomizeException( ErrorList.PASSWORD_ERROR.getMessage(),
                    ErrorList.USERNAME_ERROR.getCode(),"error");
        }
        return  "index";
    }
}
