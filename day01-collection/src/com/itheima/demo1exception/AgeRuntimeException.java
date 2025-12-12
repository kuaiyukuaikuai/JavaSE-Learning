package com.itheima.demo1exception;

/**
 * 自定义的编译时异常
 * 1.继承RuntimeException
 * 2.重写RuntimeExcpetion的构造器
 * 3.使用throw抛出异常
 */

public class AgeRuntimeException extends RuntimeException{
    public AgeRuntimeException() {
    }
    public AgeRuntimeException(String message) {
        super(message);
    }
}
