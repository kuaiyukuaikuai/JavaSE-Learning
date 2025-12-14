package com.kuaiyukuaikuai.demo2threadapi;

public class ThreadApiDemo1 {
    //main方法本身运行在主线程中
    public static void main(String[] args) {
        //目标:认识多线程,掌握创建线程的方式一:继承Thread类
        //1.定义一个子类继承Thread类,成为一个线程类
        Thread t1 = new MyThread("线程1");
        //t1.setName("线程1");
        t1.start();//启动线程
        System.out.println(t1.getName());

        Thread t2 = new MyThread("线程2");
        //t2.setName("线程2");
        t2.start();
        System.out.println(t2.getName());

        //哪个线程调用这个代码,这个代码就拿到哪个线程
        Thread m=Thread.currentThread();//主线程
        m.setName("主线程");
        System.out.println(m.getName());//main

    }
}


class MyThread extends Thread {
    public MyThread(String name) {
        this.setName(name);
    }
    //2.重写一个run方法,线程任务
    @Override
    public void run() {
        //线程任务
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "子线程输出:" + i);
        }
    }
}