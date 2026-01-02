package com.kuaiyukuaikuai.demo3nnotation;

@MyTest2(value = "hello", height = 1.7, address = {"北京", "上海"})
public class Demo {
    @MyTest2(value = "hello2", height = 1.7, address = {"湖南", "湖北"})
    public void show(){
        System.out.println("show方法");
    }
}
