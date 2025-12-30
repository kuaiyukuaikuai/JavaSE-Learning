package com.kuaiyukuaikuai.demo7executorService;

import java.util.concurrent.*;

public class ExecutorServiceDemo1 {
    public static void main(String[] args) {
        //目标:认识并且创建线程池
        //1.使用线程池的实现类ThreadPoolExecutor声明7个参数来创建线程池对象
        ExecutorService executor = new ThreadPoolExecutor(3, 5,
                10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        //2.使用线程池对象执行任务
        Runnable target=new MyRunnable();
        //execute 是 ExecutorService 接口中的核心方法，用于提交任务到线程池执行。
        executor.execute(target);
        executor.execute(target);
        executor.execute(target);
        executor.execute(target);
        executor.execute(target);
        executor.execute(target);
        executor.execute(target);
        executor.execute(target);
        executor.execute(target);
        //target可以被多次调用,target 实际上是一个 MyRunnable 对象，它只是定义了"要做什么

    }
}
