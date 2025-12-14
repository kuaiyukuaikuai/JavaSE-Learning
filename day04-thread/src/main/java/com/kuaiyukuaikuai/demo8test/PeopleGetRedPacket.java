package com.kuaiyukuaikuai.demo8test;

import java.util.List;

public class PeopleGetRedPacket extends Thread {
    private List<Integer> redPacket;

    public PeopleGetRedPacket(List<Integer> redPacket, String name) {
        super(name);
        this.redPacket = redPacket;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        while (true) {
            synchronized (redPacket) {
                if (redPacket.size() == 0) {
                    System.out.println(name + "没有抢到红包");
                    break;
                }
                //随机一个索引
                int index = (int) (Math.random() * redPacket.size());
                if (redPacket.size() > 0) {
                    System.out.println(name + "抢到红包:" + redPacket.remove(index));
                    if (redPacket.size() == 0){
                        System.out.println("活动结束");
                        break;
                    }
                }
            }
        }
    }
}
