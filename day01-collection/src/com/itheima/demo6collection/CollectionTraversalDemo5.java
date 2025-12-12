package com.itheima.demo6collection;

import java.util.ArrayList;
import java.util.function.Consumer;

public class CollectionTraversalDemo5 {
    public static void main(String[] args) {
        //目标:集合的遍历:Lambda表达式
        //创建集合对象
        ArrayList<String> names = new ArrayList<>();
        //添加元素
        names.add("张三");
        names.add("张三丰");
        names.add("张无忌");
        names.add("张三");

//        names.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });

        names.forEach(s-> System.out.println(s));
    }
}
