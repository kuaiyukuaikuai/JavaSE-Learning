package com.itheima.demo1exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo1 {
    public static void main(String[] args) {
        //目标:认识异常的体系,搞清楚异常的基本作用
/*        System.out.println("show程序开始");
        show();
        System.out.println("show程序结束");*/

        try {
            show2();
        } catch (ParseException e) {
            e.printStackTrace();//输出异常信息
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void show2() throws ParseException, FileNotFoundException {
        System.out.println("show2方法开始");
        //编译异常
        String str="2024-07-09 11:12:13";
        //把字符串时间解析成Java中的一个日期对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(str);//编译时异常,提示程序很容易出错
        System.out.println(date);

        InputStream is= new FileInputStream("d:/a.txt");
        System.out.println("show2方法结束");
    }
    public static void show() {
        //运行时异常的特点,编译时不报错,运行时出现异常,继承自 RuntimeException
        int[] arr = {10, 20, 30};
        // System.out.println(arr[3]);//ArrayIndexOutOfBoundsException
        //System.out.println(10/0);//ArithmeticException
        //空指针异常
        String str = null;
        System.out.println(str);
        System.out.println(str.charAt(0));//NullPointerException
    }
}
