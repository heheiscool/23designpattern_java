package com.strategy.context;

public class StrategyC implements Strategy {
    @Override
    public void update() {
        System.out.println("执行策略C...");
    }
}
