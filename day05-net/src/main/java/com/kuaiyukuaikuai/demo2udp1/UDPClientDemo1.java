package com.kuaiyukuaikuai.demo2udp1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClientDemo1 {
    public static void main(String[] args) throws Exception {
        //目标:完成UDP通信一发一收,客户端开发
        System.out.println("客户端启动..");
        //1.创建UDP通信的发送端对象
        DatagramSocket socket =new DatagramSocket();
        //2.创建数据,并把数据打包
        byte[] data="hello,UDP".getBytes();
        DatagramPacket packet=new DatagramPacket(data,data.length, InetAddress.getLocalHost(),8080);
        //3.发送数据
        socket.send(packet);
        socket.close();
    }
}
