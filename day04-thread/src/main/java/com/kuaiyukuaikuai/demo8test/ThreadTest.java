package com.kuaiyukuaikuai.demo8test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadTest {
    public static void main(String[] args) {
        //目标:完成多线程小案例
        //红包雨游戏:某企业有100名员工,员工的工号为1,2,3,4,...到100
        //现在公司发出去200个红包,小红包在[1 - 30]元之间,总占比80%,大红包在[31 - 100]元之间,总占比20%
        //分析:100个员工实际就是100个线程,来竞争200个红包
        List<Integer> redPacket = getRedPacket();
        //2.定义线程类,创建100个线程,竞争同一个集合
        for (int i = 0; i < 100; i++) {
            new PeopleGetRedPacket(redPacket, "员工" + i).start();
        }
    }

    public static List<Integer> getRedPacket() {
        Random random = new Random();
        List<Integer> redPacket = new ArrayList<>();
        for (int i = 0; i < 160; i++) {
            redPacket.add(random.nextInt(30) + 1);
        }
        for (int i = 0; i < 40; i++){
            redPacket.add(random.nextInt(79) + 31);
        }
        return redPacket;
    }
}
