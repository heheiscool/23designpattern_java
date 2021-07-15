package com.structpattern.proxygame;

public class ClientDemo {
    public static void main(String[] args) {
        IGamePlayer iGamePlayer = new GamePlayerImpl("李逍遥");
        IGamePlayer proxy = new GamePlayerProxy(iGamePlayer);
        proxy.killBoss();
        proxy.upGrade();

    }
}
