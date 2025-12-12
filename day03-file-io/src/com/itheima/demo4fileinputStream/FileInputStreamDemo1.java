package com.itheima.demo4fileinputStream;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        //目标:掌握文件字节输入流读取文件中的字节数组到内存中来
        //1.创建文件字节输入流管道与源文件接通
        InputStream is = new FileInputStream("day03-file-io\\src\\dilei02.txt");
        //2.创建字节数组,用于装文件字节数据
        byte[] bytes = new byte[1024];
        //3.读取文件字节数据到字节数组中
        int len = is.read(bytes);
        //4.把字节数组中的数据转换为字符串
        String text = new String(bytes, 0, len);
        System.out.println(text);
        //5.释放资源
        is.close();
        System.out.println("文件读取完毕!");
    }
}
