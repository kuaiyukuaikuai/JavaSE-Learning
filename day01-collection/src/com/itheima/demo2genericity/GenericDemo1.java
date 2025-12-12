package com.itheima.demo2genericity;

import java.util.ArrayList;

public class GenericDemo1 {
    public static void main(String[] args) {
        //目标:认识泛型
        ArrayList<String> list = new ArrayList();//使用泛型,集合中只能存放String类型数据
        list.add("hello");
        list.add("world");
        //获取数据
        for (int i = 0; i < 10; i++){
            Object obj = list.get(i);
            //将数据转型
            String s = (String) obj;
            System.out.println(s);
        }
    }
}
