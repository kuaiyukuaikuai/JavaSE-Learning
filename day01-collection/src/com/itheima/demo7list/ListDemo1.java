package com.itheima.demo7list;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo1 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("张三");
        names.add("李四");
        names.add("王五");
        names.add("赵六");


        //给第三个位置插入一个数据:赵敏
        names.add(2,"赵敏");
        System.out.println(names);

        //删除李四,根据下标
        names.remove(1);

        //把王五改成金毛
        System.out.println(names.set(2,"金毛"));//返回修改前的元素
        System.out.println(names);

        //获取张三的位置
        System.out.println(names.get(0));


        System.out.println("-----------四种遍历演示------------");
        //1.for循环
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        //2.迭代器
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        //3.增强for循环
        for (String name : names) {
            System.out.println(name);
        }

        //4.Lambda表达式
        names.forEach(name -> System.out.println(name));
    }

}
