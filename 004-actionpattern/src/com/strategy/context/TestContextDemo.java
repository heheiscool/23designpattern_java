package com.strategy.context;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.strategy
 * @ClassName: TestContextDemo
 * @Author: chenyang
 * @Description: 上下文测试
 * @Date: 2021/1/7 11:23 AM
 * @Version: 1.0
 */
public class TestContextDemo {
    public static void main(String[] args) {
        Strategy strategy = new StrategyA();
        Context context = new Context(strategy);
        context.contextInterface();
    }
}
