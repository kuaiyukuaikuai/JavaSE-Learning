package com.kuaiyukuaikuai.demo3threadsafe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String cardId;//卡号
    private double money;//账户余额


    public void drawMoney(int i) {
        //模拟取钱
        String name = Thread.currentThread().getName();
        if (money >= i) {
            System.out.println(name + "取钱成功,取钱金额:" + i);
            money -= i;
            System.out.println("余额:" + money);
        } else {
            System.out.println(name + "取钱失败,余额不足");
        }
    }
}
