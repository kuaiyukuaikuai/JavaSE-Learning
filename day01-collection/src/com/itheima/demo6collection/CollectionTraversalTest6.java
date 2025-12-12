package com.itheima.demo6collection;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionTraversalTest6 {
    public static void main(String[] args) {
        //目标:认识并发修改异常,搞清楚每种遍历的区别
        ArrayList<String> list = new ArrayList<>();
        list.add("Java入门");
        list.add("宁夏枸杞");
        list.add("黑枸杞");
        list.add("Java进阶");
        list.add("JavaWeb");
        list.add("顶级枸杞");
        list.add("枸杞子");
        list.add("西洋参");

        //需求1:删除全部枸杞
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.contains("枸杞")) {
                list.remove(s);
            }
        }
        System.out.println(list); //[Java入门, 黑枸杞, Java进阶, JavaWeb, 枸杞子, 西洋参]并发修改异常


        //需求1:删除全部枸杞
        System.out.println("===================");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Java入门");
        list2.add("宁夏枸杞");
        list2.add("黑枸杞");
        list2.add("Java进阶");
        list2.add("JavaWeb");
        list2.add("顶级枸杞");
        list2.add("枸杞子");
        list2.add("西洋参");
        for (int i = 0; i < list2.size(); i++) {
            String s = list2.get(i);
            if (s.contains("枸杞")) {
                list2.remove(s);
                i--;
            }
        }
        System.out.println(list2);


        //需求1:删除全部枸杞 倒着遍历并且删除(前提支持索引)
        System.out.println("===================");
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("Java入门");
        list3.add("宁夏枸杞");
        list3.add("黑枸杞");
        list3.add("Java进阶");
        list3.add("JavaWeb");
        list3.add("顶级枸杞");
        list3.add("枸杞子");
        list3.add("西洋参");
        for (int i = list3.size() - 1; i >=0; i--) {
            String s = list3.get(i);
            if (s.contains("枸杞")) {
                list3.remove(s);
            }
        }
        System.out.println(list3);

        //需求1:删除全部枸杞
        //方案2,迭代器遍历并删除默认也存在并发修改问题
        //解决方法:使用迭代器自己的方法删除
        System.out.println("===================");
        ArrayList<String> list4 = new ArrayList<>();
        list4.add("Java入门");
        list4.add("宁夏枸杞");
        list4.add("黑枸杞");
        list4.add("Java进阶");
        list4.add("JavaWeb");
        list4.add("顶级枸杞");
        list4.add("枸杞子");
        list4.add("西洋参");
        for (Iterator<String> it = list4.iterator(); it.hasNext();) {
            String s = it.next();
            if (s.contains("枸杞")) {
                it.remove();
            }
        }
        System.out.println(list4);


        //需求1:删除全部枸杞
        //方案3和4,增强for循环和Lambda表达式无法删除
        System.out.println("===================");
        ArrayList<String> list5 = new ArrayList<>();
        list5.add("Java入门");
        list5.add("宁夏枸杞");
        list5.add("黑枸杞");
        list5.add("Java进阶");
        list5.add("JavaWeb");
        list5.add("顶级枸杞");
        list5.add("枸杞子");
        list5.add("西洋参");
        for (String s : list5) {
            if (s.contains("枸杞")) {
                list5.remove(s);
            }
        }//错误:并发修改异常
    }
}
