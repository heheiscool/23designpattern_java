package com.strategy.context;

public class StrategyA implements Strategy{
    @Override
    public void update() {
        System.out.println("执行策略A...");
    }
}
