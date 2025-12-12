package com.yourname.demo2threadapi;

public class ThreadApiDemo3 {
    public static void main(String[] args) {
        //目标:掌握线程的join方法,线程的插队
        MyThread2 t1 = new MyThread2();
        t1.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程输出:" + i);
            if (i == 10) {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("子线程输出:" + i);
        }
    }
}
