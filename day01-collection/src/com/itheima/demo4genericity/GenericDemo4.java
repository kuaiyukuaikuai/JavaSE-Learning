package com.itheima.demo4genericity;

public class GenericDemo4 {
    public static void main(String[] args) {
        //目标:学会定义泛型方法,搞清楚作用
        //需求:打印任意数组的内容
        String[] arr = {"张三", "李四", "王五"};
        printArray(arr);
        Integer[] arr1 = {10, 20, 30};//Integer是int的包装类
        printArray(arr1);
    }

    public static <T> void printArray(T[] arr) { //T是任意类型
        for (T t : arr) {
            System.out.println(t);
        }
    }
}
