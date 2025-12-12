package com.yourname.demo1create;

public class ThreadDemo2 {
    public static void main(String[] args) {
        //目标:认识多线程,掌握创建线程的方式二:实现Runnable接口
        //1.定义一个类实现Runnable接口
        Runnable mr = new MyRunnable();
        //2.创建Thread类对象,构造方法中传递Runnable接口的实现类对象
        Thread t = new Thread(mr);
        //3.调用start方法启动线程
        t.start();
        for (int i = 0; i < 5; i++){
            System.out.println("主线程输出:" + i);
        }
    }

    static class MyRunnable implements Runnable{
        //3.重写run方法,线程任务
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("子线程输出:" + i);
            }
        }
    }
}
