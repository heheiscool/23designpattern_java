package com.strategy.context;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.strategy
 * @ClassName: Context
 * @Author: chenyang
 * @Description: 上下文索引
 * @Date: 2021/1/7 11:21 AM
 * @Version: 1.0
 */
public class Context {
    private Strategy strategy = null;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    //调用策略方法
    public void contextInterface(){
        this.strategy.update();
    }
}
