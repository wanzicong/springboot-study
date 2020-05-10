package com.exception.exception;

import lombok.Data;

/*自定义的异常类*/
@Data
public class CustomizeException  extends  RuntimeException{
    /*异常的信息*/
    String message;

    public CustomizeException(String message ) {
        this.message = message;
    }
}
