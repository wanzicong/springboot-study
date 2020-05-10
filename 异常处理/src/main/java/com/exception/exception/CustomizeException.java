package com.exception.exception;

import lombok.Data;

/*自定义的异常类*/
@Data
public class CustomizeException  extends  RuntimeException{
    /*异常的信息*/
    String message;
    /*异常的代码*/
    Integer code;
    /*这个请求即将要返回的地址*/
    String url;

    public CustomizeException(String message,Integer code ,String url) {
        this.message = message;
        this.code = code;
        this.url = url;
    }
}
