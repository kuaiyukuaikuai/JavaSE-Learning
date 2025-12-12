package com.itheima.demo3charset;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CharSetDemo1  {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //目标:写程序实现字符编码和解码
        //1.编码
        String s = "中国abc5555";
        //byte[] bytes = s.getBytes(); // 默认编码
        byte[] bytes = s.getBytes("GBK");//指定编码
        System.out.println( bytes.length);
        System.out.println(Arrays.toString(bytes));

        //2.解码
        String s1 = new String(bytes,"GBK");//指定解码
        System.out.println(s1);
    }
}
