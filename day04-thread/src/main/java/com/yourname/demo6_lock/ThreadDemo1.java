package com.yourname.demo6_lock;

public class ThreadDemo1 {
    public static void main(String[] args) {
        //目标:多线程操作同一个账户
        //1.创建一个账户对象，创建小明小红的共同账户,存入1000元
        Account acc = new Account("中国工商银行", 1000);

        //2.创建两个线程，模拟同时去同一个账户取1000元
        new DrawThread("小明", acc).start();
        new DrawThread("小红", acc).start();
    }
}
