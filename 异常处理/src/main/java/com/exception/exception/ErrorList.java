package com.exception.exception;

import lombok.Data;


public enum ErrorList {

    PASSWORD_ERROR("密码错误",20001),
    USERNAME_ERROR("用户名错误",20002);
    private String message;
    private Integer code;
    /*获取message*/
    public String getMessage(){
        return  this.message;
    }
    /*获取code*/
    public Integer getCode(){
        return  this.code;
    }
    /*构造方法*/
    ErrorList(String message,Integer code) {
        this.message = message;
        this.code = code;
    }
}
