package com.kuaiyukuaikuai.demo3nnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationDemo4 {
    public static void main(String[] args) throws Exception {
        AnnotationDemo4 ad = new AnnotationDemo4();
        Class c1 = AnnotationDemo4.class;
        Method[] methods = c1.getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(MyTest1.class)) {
                MyTest1 mt = m.getAnnotation(MyTest1.class);
                for (int i = 0; i < mt.Count(); i++) {
                    m.invoke(ad);
                }
            }
        }
    }

    @MyTest1(Count = 1)
    public void test1() {
        System.out.println("test1方法执行了...");
    }

    @MyTest1(Count = 2)
    public void test2() {
        System.out.println("test2方法执行了...");
    }

    public void test3() {
        System.out.println("test3方法执行了...");
    }

    @MyTest1(Count = 4)
    public void test4() {
        System.out.println("test4方法执行了...");
    }
}
