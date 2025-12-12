package com.itheima.demo6collection;

import java.util.ArrayList;

public class CollectionDemo2 {
    public static void main(String[] args) {
        //目标:集合的遍历
        //创建集合对象
        ArrayList<String> list = new ArrayList<>();
        //添加元素
        list.add("张三");
        list.add("张三");
        list.add("张三");
        list.add("张三");
        list.add("张三");

        //获取集合的元素个数
        int size = list.size();
        //删除集合中的元素
        list.remove(0);
        //判断集合是否为空
        boolean empty = list.isEmpty();
        //清空集合
        list.clear();
        //判断集合中是否存在某个元素
        boolean contains = list.contains("张三");
        //把集合转为数组
        String[] arr = list.toArray(new String[0]);

        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }
    }
}
