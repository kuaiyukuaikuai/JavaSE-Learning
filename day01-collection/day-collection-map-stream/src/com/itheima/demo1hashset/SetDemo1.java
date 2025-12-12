package com.itheima.demo1hashset;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo1 {
    public static void main(String[] args) {
        //目标:认识Set家族集合特点
        //创建一个Set集合:无序,不重复,无索引
        //Set<String> set = new HashSet<>();//无序,不重复,无索引
        Set<String> set = new LinkedHashSet<>();//有序,不重复,无索引
        set.add("java");
        set.add("hello");
        set.add("hello");
        set.add("鸿蒙");
        set.add("java");
        set.add("鸿蒙");
        set.add("大数据");
        System.out.println(set);

        //创建一个TreeSet集合:无序,不重复,无索引,元素按照大小排序
        Set<Double> set1 = new TreeSet<>();
        set1.add(10.0);
        set1.add(20.0);
        set1.add(5.0);
        set1.add(15.0);
        System.out.println(set1);

    }
}
