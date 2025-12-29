package com.kuaiyukuaikuai.demo1inetaddress;

import java.net.InetAddress;

public class InetAddressDemo1 {
    public static void main(String[] args) {
        //目标:获取本机的IP地址
        try {
            //1.获取本机的IP地址
            InetAddress ip1 = InetAddress.getLocalHost();//getLocalHost()获取本机的IP地址(静态方法)
            System.out.println(ip1.getHostAddress());//getHostAddress()获取本机的IP地址(实例方法)
            System.out.println(ip1.getHostName());//getHostName()获取本机的主机名
            System.out.println(ip1);
            //2.获取指定IP地址
            InetAddress inet1 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet1);
            System.out.println(inet1.getHostAddress());

            InetAddress inet2 = InetAddress.getByName("192.168.1.1");
            System.out.println(inet2);

            //判断本机与对方主机是否互通
            System.out.println(inet1.isReachable(5000)); //5000毫秒内可以ping通
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
