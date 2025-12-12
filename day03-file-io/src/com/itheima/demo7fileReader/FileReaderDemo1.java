package com.itheima.demo7fileReader;

import java.io.FileReader;
import java.io.Reader;

public class FileReaderDemo1 {
    public static void main(String[] args) {
        //目标:掌握文件字符输入流读取文件内容
        try (Reader fr = new FileReader("day03-file-io\\src\\dilei06.txt")) {
            //定义一个字符数组,每次读多个字符
            char[] chars = new char[3];
            int len = -1;
            while ((len = fr.read(chars)) != -1) {
                //把字符数组转换成字符串,并打印
                System.out.print(new String(chars, 0, len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
