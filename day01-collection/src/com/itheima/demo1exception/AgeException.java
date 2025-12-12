package com.itheima.demo1exception;

/**
 * 自定义的编译时异常
 * 1.继承Exception
 * 2.重写Excpetion的构造器
 * 3.使用throw抛出异常
 */

public class AgeException extends Exception{
    public AgeException() {
    }
    public AgeException(String message) {
        super(message);
    }
}
