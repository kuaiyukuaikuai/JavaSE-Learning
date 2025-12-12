package com.itheima.demo1exception;

public class ExceptionDemo2 {
    public static void main(String[] args) {
        //目标:搞清楚异常的作用
        try {
            System.out.println(div(10, 0));
            System.out.println("底层方法执行成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("底层方法执行失败");
        }
        System.out.println("程序继续执行");
        System.out.println("程序结束");
    }

    //需求:求2个数的除的结果,并返回这个结果
    public static int div(int a, int b) throws Exception {
        if (b == 0) {
            System.out.println("除数不能为0");
            //返回一个异常给上层调用者,返回的异常还可告知上层底层是执行成功还是执行失败
//            throw  new RuntimeException("除数不能为0");        //运行时异常,不需要处理,直接抛给调用者

            //替代return 直接返回一个异常,还可以让程序继续运行
            throw new Exception("除数不能为0");//抛出编译时异常,必须处理,要么try...catch,要么throws
        }
        int result = a / b;
        return result;
    }
}
