package com.structpattern.proxygame;

import java.util.Date;

public class GamePlayerProxy implements IGamePlayer{
    private IGamePlayer player = null;

    public GamePlayerProxy(IGamePlayer player) {
        this.player = player;
    }

    //记录打怪时间
    public void log(){
        System.out.println("打怪时间"+new Date().toString());
    }

    //计算升级时间
    public void count(){
        System.out.println("升级一级耗费50小时");
    }

    @Override
    public void killBoss() {
        this.log();
        player.killBoss();
    }

    @Override
    public void upGrade() {
        player.upGrade();
        this.count();
    }
}
