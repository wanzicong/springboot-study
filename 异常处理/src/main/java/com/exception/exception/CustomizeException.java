package com.exception.exception;

import lombok.Data;

/*自定义的异常类*/
@Data
public class CustomizeException  extends  RuntimeException{
    /*异常的信息*/
    String message;
    Integer code;

    public CustomizeException(String message,Integer code ) {
        this.message = message;
        this.code = code;
    }
}
