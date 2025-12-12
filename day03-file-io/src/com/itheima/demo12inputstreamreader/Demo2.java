package com.itheima.demo12inputstreamreader;

import java.io.*;

public class Demo2 {
    public static void main(String[] args) {
        try (
                //先提取文件的原始字节流
                InputStream is=new FileInputStream("day03-file-io\\src\\dilei09.txt");
                //把原始字节流转换为字符输入流
                Reader isr = new InputStreamReader(is, "gbk");
                //把字符输入流转换为缓冲字符输入流
                BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }catch (Exception e)
            {
            e.printStackTrace();
        }
    }
}
