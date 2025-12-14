package com.kuaiyukuaikuai.demo4_synchronized_code;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String cardId;//卡号
    private double money;//账户余额


    public  void drawMoney(int i) {
        //模拟取钱
        String name = Thread.currentThread().getName();
        //同步代码块,使用当前账户作为锁对象
        synchronized (this) {
            if (money >= i) {
                System.out.println(name + "取钱成功,取钱金额:" + i);
                money -= i;
                System.out.println("余额:" + money);
            } else {
                System.out.println(name + "取钱失败,余额不足");
            }
        }
    }
}
