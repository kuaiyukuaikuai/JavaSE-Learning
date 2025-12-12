package com.itheima.demo13_printstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamDemo1 {

    // 目标:掌握打印流基本使用
    public static void main(String[] args) {
        try (
                // 创建打印流对象
                //PrintStream ps = new PrintStream("day03-file-io\\src\\dilei09.txt")
                //追加
                 PrintStream ps = new PrintStream(new FileOutputStream("day03-file-io\\src\\dilei09.txt", true))

        ) {
            ps.print("hello");
            ps.println("hello");
            ps.println(true);
            ps.println(100);
            ps.println(100.0);
            ps.println('a');
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
