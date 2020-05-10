package com.exception.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class MyExceptionHandler {

        /*异常的全局处理类*/
    @ExceptionHandler(value = Exception.class)
        ModelAndView  handleException(Throwable e, Model model, HttpServletRequest request, HttpServletResponse response ){
             String url ;
            /*如果得到的异常是自己定义的异常类*/
            if (e instanceof  CustomizeException){
                /*获取异常信息数据*/
                model.addAttribute("message",e.getMessage());
                model.addAttribute("code",((CustomizeException) e).getCode());
                model.addAttribute("url",  request.getServletPath());
            }else {
                /*如果不是自定义的异常类*/
                model.addAttribute("message","服务器累啦");
                /*打印异常信息*/
                e.printStackTrace();
            }
            /*在自定义类中定义这个请求原本要返回的页面*/
             url = ((CustomizeException) e).getUrl();
            return  new ModelAndView(url);
        }


}
