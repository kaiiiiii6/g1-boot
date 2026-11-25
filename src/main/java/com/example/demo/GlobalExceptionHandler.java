package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Void> onInvalid(MethodArgumentNotValidException e){
        String field=e.getBindingResult()
                .getFieldErrors().isEmpty()?"unknown":e.getBindingResult().getFieldErrors().get(0).getField();
        String msg=e.getBindingResult()
                .getFieldErrors().isEmpty()? "参数不合格":e.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        return Result.fail(400,"字段"+field+","+msg);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<Void> onRuntime(RuntimeException e){
        return Result.fail(500,"服务器处理失败");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Void> onUnreadable(HttpMessageNotReadableException e){
        return Result.fail(400,"请求体缺失或格式不对");
    }
}
