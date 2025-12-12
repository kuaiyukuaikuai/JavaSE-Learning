package com.itheima.demo1exception;

public class ExceptionDemo4 {
    public static void main(String[] args) {
        //目标:认识自定义异常-运行时异常
        try {
            saveAge(300);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("保存年龄失败");
        }
    }

    //需求:我们公司的系统只要收到年龄小于1岁或者大于200岁就是一个年龄非法异常
    public static void saveAge(int age)  {   //默认抛出运行时异常
        if (age < 1 || age > 200) {
            throw new AgeRuntimeException("年龄非法");
        } else {
            System.out.println("保存年龄成功");
        }
    }
}
