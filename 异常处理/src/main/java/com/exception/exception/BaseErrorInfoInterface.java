package com.exception.exception;

/*获取异常的信息====code 和 message */
public interface BaseErrorInfoInterface {

    /** 错误码*/
    String getResultCode();

    /** 错误描述*/
    String getResultMsg();

}
