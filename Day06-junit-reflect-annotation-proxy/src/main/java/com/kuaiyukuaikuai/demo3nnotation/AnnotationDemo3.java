package com.kuaiyukuaikuai.demo3nnotation;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationDemo3 {
    //目标:解析注解
    @Test
    public void parseClass() {
        //1.获取类对象
        Class c1 = Demo.class;
        //2.判断类对象上是否有指定的注解MyTest2
        if (c1.isAnnotationPresent(MyTest2.class)) {
            //3.获取注解对象
            MyTest2 mt = (MyTest2) c1.getAnnotation(MyTest2.class);
            //4.获取注解对象中的属性值
            System.out.println(mt.value());
            System.out.println(mt.height());
            System.out.println(Arrays.toString(mt.address()));
        }
    }
    @Test
    public void parseMethod() throws NoSuchMethodException {
        Class c1 = Demo.class;
        //1.获取方法对象
        Method m1 = c1.getMethod("show");
        //2.判断方法对象上是否有指定的注解MyTest2
        if (m1.isAnnotationPresent(MyTest2.class)) {
            MyTest2 mt = m1.getAnnotation(MyTest2.class);
            System.out.println(mt.value());
            System.out.println(mt.height());
            System.out.println(Arrays.toString(mt.address()));
        }
    }
}
