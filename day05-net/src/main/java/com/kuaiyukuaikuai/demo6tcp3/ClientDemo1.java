package com.kuaiyukuaikuai.demo6tcp3;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo1 {
    public static void main(String[] args) throws Exception {
        //目标:完成TCP通信,客户端开发,多发多收
        //1.创建一个Socket对象,构造方法中绑定服务器的IP地址和端口号,Socket可以理解为端点
        System.out.println("客户端启动..");
        Socket socket = new Socket("127.0.0.1", 8888);//8888为目标端口

        //2.获取一个输出流,写数据
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要发送的数据:");
            String data = sc.next();
            if (data.equals("exit")) {
                //3.释放资源
                socket.close();
                System.out.println("客户端退出!");
                break;
            }
            dos.writeUTF(data);
            // 刷新输出流缓冲区，将缓冲区中的数据立即写入目标设备或下一级输出流。
            // 此操作确保所有缓冲的数据都被强制输出，避免数据在缓冲区中滞留。
            dos.flush();
        }


    }
}
