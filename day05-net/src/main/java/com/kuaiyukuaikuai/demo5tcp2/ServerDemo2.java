package com.kuaiyukuaikuai.demo5tcp2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo2 {
    public static void main(String[] args) throws IOException {
        //目标:完成TCP通信,服务端开发,多发多收
        //1.创建一个ServerSocket对象,构造方法中绑定服务端的端口号
        ServerSocket ss = new ServerSocket(8888);//8888为监听端口
        //2.调用accept方法,阻塞等待客户端连接,获取一个Socket对象
        Socket socket = ss.accept();
        //3.获取输入流,读取数据
        InputStream is = socket.getInputStream();
        //4.将输入流包装成特殊数据输入流
        DataInputStream dis = new DataInputStream(is);
        while (true) {
            //5.读取数据
            System.out.println(dis.readUTF());
            //6.客户端的ip和端口
            System.out.println(socket.getInetAddress().getHostAddress() + ":" + socket.getPort());
        }
    }
}
