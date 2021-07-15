package com.strategy.context;

public class StrategyB implements Strategy {
    @Override
    public void update() {
        System.out.println("执行策略B...");
    }
}
