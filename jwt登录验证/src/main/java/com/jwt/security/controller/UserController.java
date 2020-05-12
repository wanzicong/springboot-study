package com.jwt.security.controller;

import com.jwt.security.user.User;
import com.jwt.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;
    /*用户登录验证操作*/
        @RequestMapping(value = "/user/login",method = RequestMethod.POST)
        public  void index(@RequestBody User user){
            /*假设判断成功了*/
            String jwt = jwtUtil.createJWT(user.getId(), user.getName(), "user");
            System.out.println(jwt);
        }

        /*测试是否经过了验证*/
    @RequestMapping("/user")
        public  void  test(){
            System.out.println("我经过验证了");
        }
}
