package com.structpattern.proxygame;

public class GamePlayerImpl implements IGamePlayer{
    private String name = "";

    public GamePlayerImpl(String name) {
        this.name = name;
    }

    @Override
    public void killBoss() {
        System.out.println(this.name+"玩家正在打怪升级...");
    }

    @Override
    public void upGrade() {
        System.out.println(this.name+"玩家成功升级了一个级别...");
    }
}
