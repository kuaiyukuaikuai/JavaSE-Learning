package com.kuaiyukuaikuai.demo4_synchronized_code;

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
