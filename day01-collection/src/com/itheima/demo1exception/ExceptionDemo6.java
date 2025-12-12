package com.itheima.demo1exception;

import java.util.Scanner;

public class ExceptionDemo6 {
    public static void main(String[] args) {
        //目标:掌握异常的处理方案2:捕获异常对象,尝试重新修复
        //接受用户的一个定价

        while (true) {
            try {
                double price = userInputPrice();
                System.out.println("商品定价是:"+ price);
                break;
            } catch (Exception e) {
                System.out.println("输入价格有误,请重新输入");
            }
        }
        System.out.println("程序结束");
    }
    public static double userInputPrice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入商品定价:");
        double price = sc.nextDouble();
        return price;
    }
}
