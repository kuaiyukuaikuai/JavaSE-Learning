package com.itheima.demo11bufferedWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class BufferedWriterDemo1 {
    public static void main(String[] args) {
        //目标:掌握文件字符输出流写入数据到文件中
        //覆盖,追加需要在创建流对象时传入第二个参数true
        try (Writer fw = new FileWriter("day03-file-io\\src\\com\\itheima\\demo8filewriter\\dilei07.txt");
             BufferedWriter bw = new BufferedWriter(fw);
        ) {
            bw.write("hello");
            bw.write('类');
            bw.newLine();
            char[] chars = "java".toCharArray();
            bw.write(chars);
            bw.write(chars, 0, chars.length);

            bw.flush();//刷新缓冲区,确保数据写入到文件中
            //刷新后流可以继续使用
            //close()方法会自动刷新缓冲区,然后关闭流
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("文件写入完毕!");
    }
}
