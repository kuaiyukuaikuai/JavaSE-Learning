package com.kuaiyukuaikuai.demo7executorService;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
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
        return Thread.currentThread().getName() + "线程计算1+" + n + "的结果是" + sum;
    }
}
