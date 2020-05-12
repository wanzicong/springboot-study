package com.jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class IndexController {
    @RequestMapping("/index")
        public  void index(){
            System.out.println("jwt");
        }
}
