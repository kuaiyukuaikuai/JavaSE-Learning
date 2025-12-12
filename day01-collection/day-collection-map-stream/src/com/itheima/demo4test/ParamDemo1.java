package com.itheima.demo4test;

public class ParamDemo1 {
    public static void main(String[] args) {
        //认识可变参数
        sum();
        sum(1);
        sum(1,2,3);
        sum(new int[] {1,2,3,4,5});
    }
//注意事项:可变参数在形参列表只能有一个,并且只能放在形参列表的最后一个位置
    public static void sum(int... nums) {
        //可变参数实际对内就是一个数据,nums就是数组
    }
}
