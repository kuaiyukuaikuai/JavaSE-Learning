package com.kuaiyukuaikuai.demo3nnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)//保留时间，运行时
@Target({ElementType.METHOD,ElementType.FIELD})//限定注解作用范围,方法或字段
public @interface MyTest {
}
