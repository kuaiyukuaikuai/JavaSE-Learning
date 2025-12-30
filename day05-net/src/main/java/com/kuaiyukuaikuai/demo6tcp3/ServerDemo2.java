package com.kuaiyukuaikuai.demo6tcp3;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo2 {
    public static void main(String[] args) throws IOException {
        //目标:完成TCP通信,服务端开发,多发多收,支持多个客户端开发
        //1.创建一个ServerSocket对象,构造方法中绑定服务端的端口号
        ServerSocket ss = new ServerSocket(9999);//8888为监听端口
        while (true) {
            System.out.println("等待客户端连接...");
            //2.调用accept方法,阻塞等待客户端连接,获取一个Socket对象
            Socket socket = ss.accept();
            //3.把这个客户端管道交给一个独立的子线程专门负责接收这个管道的信息
            new ServerReader(socket).start();
        }
    }
}
