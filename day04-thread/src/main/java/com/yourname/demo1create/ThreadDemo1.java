package com.yourname.demo1create;

public class ThreadDemo1 {
    //main方法本身运行在主线程中
    public static void main(String[] args) {
        //目标:认识多线程,掌握创建线程的方式一:继承Thread类
        //1.定义一个子类继承Thread类,成为一个线程类
        MyThread mt = new MyThread();
        mt.start();//启动线程
        for (int i = 0; i < 100; i++){
            System.out.println("主线程输出:" + i);
        }
    }
}


class MyThread extends Thread {
    //2.重写一个run方法,线程任务
    @Override
    public void run() {
        //线程任务
        for (int i = 0; i < 100; i++) {
            System.out.println("子线程输出:" + i);
        }
    }
}