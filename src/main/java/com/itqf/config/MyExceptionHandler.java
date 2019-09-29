package com.itqf.config;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Author 贾振乾
 * Date 2019/9/21
 * Time 20:19
 */
//控制器增强
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(value=UnauthorizedException.class)
    public String ex(){
        return "unauth";
    }

    @ExceptionHandler(value=ArithmeticException.class)
    public String ar(){
        return "arith";
    }
}
