package com.yourname.demo1create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo3 {
    public static void main(String[] args) {
        //目标:认识多线程,掌握创建线程的方式三:实现Callable接口
        //1.定义一个类实现Callable接口
        Callable<String> mc = new MyCallable(100);
        //2.创建FutureTask对象,构造方法中传递Callable接口对象
        FutureTask<String> f1 = new FutureTask<>(mc);
        //3.创建Thread类对象,构造方法中传递FutureTask对象
        Thread t = new Thread(f1);
        //4.调用start方法启动线程
        t.start();

        Callable<String> mc2 = new MyCallable(50);
        FutureTask<String> f2 = new FutureTask<>(mc2);
        Thread t2 = new Thread(f2);
        t2.start();
        try {
            //如果主线程发现第一个线程没有执行完毕,则会阻塞,等待第一个线程执行完毕
            System.out.println(f1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //如果主线程发现第二个线程没有执行完毕,则会阻塞,等待第二个线程执行完毕
            System.out.println(f2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyCallable implements Callable<String> {
    private int n;

    public MyCallable(int n) {
        this.n = n;
    }

    //3.重写call方法,线程任务
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }
        return "子线程计算1+" + n + "的结果是" + sum;
    }
}
