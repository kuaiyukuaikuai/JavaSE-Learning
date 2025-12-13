package com.yourname.demo7executorService;


public class MyRunnable implements Runnable {
    //2.重写一个run方法,线程任务
    @Override
    public void run() {
        //线程任务
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}