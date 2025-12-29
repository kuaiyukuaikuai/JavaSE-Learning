package com.kuaiyukuaikuai.demo2udp1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerDemo2 {
    public static void main(String[] args) throws Exception {
        //目标:完成UDP通信一收一发,服务端开发
        System.out.println("服务端启动...");
        //1.创建UDP通信的接收端对象
        DatagramSocket socket =new DatagramSocket(8080);
        //2.创建数据包,封装接收到的数据
        byte[] buf = new byte[1024*64];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //3.接收数据
        socket.receive(packet);
        //4.把数据包中的数据,解包
        System.out.println("服务端收到数据:" + new String(packet.getData(),0,packet.getLength()));

        //获取对方的ip和程序端口
        // getAddress()方法用于获取数据包发送方的InetAddress对象
        // getHostAddress()方法将InetAddress转换为标准的IP地址字符串格式
        System.out.println("对方ip:" + packet.getAddress().getHostAddress());
        System.out.println("对方端口:" + packet.getPort());
    }
}
