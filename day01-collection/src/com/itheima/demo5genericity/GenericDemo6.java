package com.itheima.demo5genericity;

import java.util.ArrayList;

public class GenericDemo6 {
    public static void main(String[] args) {
        //目标:泛型ii和集合不支持的基本数据类型,只能支持对象类型(引用数据类型)
        ArrayList<Integer> list = new ArrayList<>();

        //手工包装
        //Integer i = new Integer(10); //过时
        Integer it1 = Integer.valueOf(10);
        Integer it2 = Integer.valueOf(10);
        System.out.println(it1 == it2);// true

        Integer it3 = Integer.valueOf(130);
        Integer it4 = Integer.valueOf(130);
        System.out.println(it3 == it4);// false //超过127范围,会创建新的对象

        //自动包装:基本数据类型的数据可以直接变成包装对象的数据,不需要额外操作
        Integer it11 = 10;
        Integer it12 = 10;
        System.out.println(it11 == it12);// true

        //自动拆包装
        int i = it11;
        System.out.println(i);

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(10);//自动包装
        list1.add(20);//自动包装
        int rs = list1.get(0);//自动拆包装
        System.out.println(rs);

        System.out.println("======================================");

        //包装类新增的功能
        //1.把基本类型的数据转化成字符串
        int j = 23;
        String rs1 = String.valueOf(j);
        System.out.println(rs1+1);//231

        Integer i2=j;
        String rs2 = i2.toString();
        System.out.println(rs2+1);//231

        String rs3=j+ "";// 将int类型数据变成字符串
        System.out.println(rs3+1);//231

        //2.把字符串转化成基本数据类型(很有用)
        String str = "98";
       // int rs4 = Integer.parseInt(str);
        int rs4 = Integer.valueOf( str);
        System.out.println(rs4+1);//99

        String str2 = "98.8";
        //double rs5 = Double.parseDouble(str2);
        double rs5 = Double.valueOf(str2);
        System.out.println(rs5+1);//99.8
    }
}
