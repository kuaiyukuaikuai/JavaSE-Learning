package com.kuaiyukuaikuai.demo1junit;

//字符串工具类
public class StringUtil {
    public static void printNumber(String name){
        if(name == null||" ".equals(name)){
            System.out.println("名字不能为空");
            return;
        }
        System.out.println("名字长度是"+name.length());
    }
    //获取字符串最大索引
    public static int getMaxIndex(String data){
        if(data == null||" ".equals( data)){
            return -1;
        }
        return data.length()-1;
    }
}

