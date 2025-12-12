package com.itheima.demo1exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo5 {
    public static void main(String[] args) {
        //目标:掌握异常的处理方案1:底层异常都抛出给最外层调用者,最外层捕获异常,记录异常,响应合适信息给用户观看

        System.out.println("show程序开始");
        try {
            show();
            System.out.println("show程序操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("程序出现异常,请稍后再试");
        }
        System.out.println("程序继续执行");
        System.out.println("程序结束");
    }

    public static void show() throws Exception {
        System.out.println("show2方法开始");
        //编译异常
        String str = "2024-07-09 11:12:13";
        //把字符串时间解析成Java中的一个日期对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(str);//编译时异常,提示程序很容易出错
        System.out.println(date);

        InputStream is = new FileInputStream("d:/a.txt");
        System.out.println("show2方法结束");
    }
}
