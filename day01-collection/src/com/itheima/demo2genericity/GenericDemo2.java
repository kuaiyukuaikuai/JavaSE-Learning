package com.itheima.demo2genericity;

public class GenericDemo2 {
    public static void main(String[] args) {
        //目标:自定义泛型类
        //需求:模拟ArrayList集合,创建一个集合MyArrayList中只能存放String类型数据
        MyArrayList<String> list = new MyArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("前端");
        list.remove("hello");
        System.out.println(list.toString());
    }
}
