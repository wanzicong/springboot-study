## 异常处理学习

 补充:

```java
    
package com.tensquare.article.web.common;
import constants.StatusCode;
import entity.ResultDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 统一异常处理类
 */
@ControllerAdvice
public class BaseExceptionHandler {
	
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultDTO error(Exception e){
        e.printStackTrace();        
        return new ResultDTO(false, StatusCode.ERROR, "执行出错");
    }
}
```

 