package com.kuaiyukuaikuai.demo4proxy;

public class Test {
    public static void main(String[] args) {
        //目标:创建代理对象
        //1.创建目标对象:设计明星类
        Star star = new Star("小王");
        //2.创建代理对象:代理类
        StarService proxy = StarProxy.createProxy(star);
        //3.调用方法:代理类对象.方法名()
        proxy.sing("歌曲1");
        System.out.println(proxy.dance("舞曲1"));
    }
}
