package com.itheima.demo6collection;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionTraversalDemo3 {
    public static void main(String[] args) {
        //目标:集合的遍历
        //创建集合对象
        ArrayList<String> names = new ArrayList<>();
        //添加元素
        names.add("张三");
        names.add("张三丰");
        names.add("张无忌");
        names.add("张三");
        System.out.println( names);

        //1.得到集合的迭代器
        Iterator<String> it = names.iterator();
        //System.out.println(it.next());//迭代器调用next方法,获取集合中的元素
        //2.使用while循环迭代集合
        while (it.hasNext()) { //it.hasNext()询问当前位置是否有元素存在,存在返回true,不存在返回false
            String name = it.next();//it.next()获取当前位置的元素,并且同时将迭代器对象指向下一元素处
            System.out.println(name);
        }
    }
}
