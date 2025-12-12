package com.itheima.demo13_printstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataStreamDem2 {
    public static void main(String[] args) {
        try (
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("day03-file-io\\src\\dilei09.txt"));
                // 创建数据输入流对象
                DataInputStream dis = new DataInputStream(new FileInputStream("day03-file-io\\src\\dilei09.txt"))

        ) {
            // 写数据
            dos.writeInt(100);
            dos.writeDouble(10.1);
            dos.writeBoolean(true);
            dos.writeChar('a');
            // 读取数据
            int b = dis.readInt();
            System.out.println(b);
            double b1 = dis.readDouble();
            System.out.println(b1);
            boolean b2 = dis.readBoolean();
            System.out.println(b2);
            char b3 = dis.readChar();
        }catch (Exception e)
            {
            e.printStackTrace();
        }
    }
}
