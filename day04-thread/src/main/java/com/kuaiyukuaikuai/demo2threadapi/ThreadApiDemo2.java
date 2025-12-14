package com.kuaiyukuaikuai.demo2threadapi;

public class ThreadApiDemo2 {
    public static void main(String[] args) {
        //目标:搞清楚Thread类中的sleep方法
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程输出:" + i);
            try {
                //线程让步,让出cpu执行权
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
