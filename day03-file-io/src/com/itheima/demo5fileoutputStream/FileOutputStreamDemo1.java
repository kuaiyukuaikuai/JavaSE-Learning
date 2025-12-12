package com.itheima.demo5fileoutputStream;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class FileOutputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        //目标:掌握文件字节输出流写入数据到文件中
        //1.创建文件字节输出流管道与目标文件接通
        //OutputStream os = new FileOutputStream("day03-file-io\\src\\dilei03.txt"); // 覆盖
        OutputStream os = new FileOutputStream("day03-file-io\\src\\dilei03.txt", true);//追加
        //2.写入数据
        os.write(98);
        os.write('a');
        //os.write("习");  // 中文字符无法写入
        os.write("\r\n".getBytes());

        //3.写入一个字节数组
        byte[] bytes = "我爱你中国".getBytes(StandardCharsets.UTF_8);
        os.write(bytes);
        os.write("\r\n".getBytes());

        //4.写一个字节数组的一部分出去
        os.write(bytes, 0, 3);
        os.write("\r\n".getBytes());
        os.close();
        System.out.println("文件写入完毕!");


    }
}
