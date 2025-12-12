package com.itheima.demo6collection;

import java.util.ArrayList;

public class CollectionTraversalDemo4 {
    public static void main(String[] args) {
        //目标:集合的遍历:增强for循环
        //创建集合对象
        ArrayList<String> names = new ArrayList<>();
        //添加元素
        names.add("张三");
        names.add("张三丰");
        names.add("张无忌");
        names.add("张三");
        System.out.println( names);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
