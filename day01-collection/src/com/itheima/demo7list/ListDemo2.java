package com.itheima.demo7list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo2 {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        //入队
        queue.add("张三");
        queue.add("李四");
        queue.add("王五");
        queue.add("赵六");
        System.out.println(queue);

        //出队
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue);


        System.out.println("----------------------");
        //建一个栈
        LinkedList<String> stack = new LinkedList<>();
        //压栈
        stack.add("第1颗子弹");
        stack.add("第2颗子弹");
        stack.add("第3颗子弹");
        stack.add("第4颗子弹");
        System.out.println(stack);

        //出栈
        System.out.println(stack.removeLast());
        System.out.println(stack.removeLast());
        System.out.println(stack);
    }
}
