package com.jwt.security.exceptionHandel;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*公共异常处理类*/
@RestControllerAdvice
public class BaseExceptionHandler {
    /* 默认处理所有异常*/
    @ExceptionHandler
    public void error(Throwable e) {


        /*处理为登录的操作*/
        if (e instanceof  MyException){
            String code = ((MyException) e).getCode();
            /*用户未登录*/
            if (code.equals("505")){
                System.out.println("你他妈的还没有登录");
            }
        }




    }
}
