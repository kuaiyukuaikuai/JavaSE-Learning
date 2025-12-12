package com.yourname.demo1create;

public class ThreadDemo2_2 {
    public static void main(String[] args) {
        //简化1
        Runnable r=new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("子线程输出:" + i);
                }
            }
        };
        new Thread(r).start();

        //简化2
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("子线程输出:" + i);
                }
            }
        }).start();


        //简化3
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("子线程输出:" + i);
            }
        }
        ).start();
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程输出:" + i);
        }

    }
}
