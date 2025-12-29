package com.kuaiyukuaikuai.demo3udp2;

import lombok.val;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClientDemo1 {
    public static void main(String[] args) throws Exception {
        //目标:完成UDP通信多发多收,客户端开发
        System.out.println("客户端启动..");
        //1.创建UDP通信的发送端对象
        DatagramSocket socket = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要发送的数据:");
            String msg = sc.nextLine();
            //2.创建数据,并把数据打包

            if ("exit".equals(msg)) {
                System.out.println("客户端退出..");
                socket.close();
                break;
            }

            byte[] data = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 8080);
            //3.发送数据
            socket.send(packet);
        }

    }
}
