package com.kuaiyukuaikuai.demo7executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo3 {
    public static void main(String[] args) {
        //目标:通过线程池工具类:Executors创建线程池对象
        ExecutorService pool = Executors.newFixedThreadPool(3);
        //使用线程池处理Callable任务
        Future<String> f1 = pool.submit(new MyCallable(100));
        Future<String> f2 = pool.submit(new MyCallable(50));
        Future<String> f3 = pool.submit(new MyCallable(200));
        Future<String> f4 = pool.submit(new MyCallable(300));
        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
            System.out.println(f4.get());
        } catch (Exception e) {
            System.out.println("获取Callable线程的返回值失败了...");
            e.printStackTrace();
        }
    }
}
