package com.itheima.demo6collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionDemo1 {
    public static void main(String[] args) {
        //目标:集合的创建
        //1.List集合,有序、可重复、有索引
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println(list);//[hello, world, java]顺序和添加的顺序一致
        System.out.println(list.get(1));


        //2.Set集合,无序、不可重复、无索引
        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("world");
        set.add("java");
        set.add("java");
        set.add("鸿蒙");
        System.out.println(set);//[java, world, 鸿蒙, hello]

    }
}
