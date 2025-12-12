package com.itheima.demo3stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo1 {
    public static void main(String[] args) {
        //目标:Stream流
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张小四");
        list.add("张小三");
        list.add("张二");

        //1.先用传统方法,找出姓张的,名字为3个字,存入到新集合中
        List<String> newList = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("张") && name.length() == 3) {
                newList.add(name);
            }
        }
        System.out.println(newList);
        //2.用Stream流,找出姓张的,名字为3个字,存入到新集合中
        List<String> newList2 = list.stream().filter(name -> name.startsWith("张") && name.length() == 3).collect(Collectors.toList());
        System.out.println(newList2);
    }
}
