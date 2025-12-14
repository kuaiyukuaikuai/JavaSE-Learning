package com.kuaiyukuaikuai.demo6_lock;

public class DrawThread extends Thread {
    private Account account;//账户


    public DrawThread(String name, Account account) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        account.drawMoney(1000);
    }
}
