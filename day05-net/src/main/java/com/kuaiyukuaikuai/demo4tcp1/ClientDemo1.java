package com.kuaiyukuaikuai.demo4tcp1;

import java.io.DataOutputStream;
import java.net.Socket;

public class ClientDemo1 {
    public static void main(String[] args) throws Exception {
        //目标:完成TCP通信,客户端开发
        //1.创建一个Socket对象,构造方法中绑定服务器的IP地址和端口号,Socket可以理解为端点
        System.out.println("客户端启动..");
        Socket socket = new Socket("127.0.0.1", 8888);//8888为目标端口

        //2.获取一个输出流,写数据
         DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
         dos.writeUTF("hello,服务器");
         dos.writeInt(100);


         //3.释放资源
         socket.close();
    }
}
