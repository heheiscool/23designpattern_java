package com.observer.basic;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.observer
 * @ClassName: ConcreteObserver
 * @Author: chenyang
 * @Description: 具体观察者
 * @Date: 2021/1/7 12:32 PM
 * @Version: 1.0
 */
public class ConcreteObserver implements Observer{

    @Override
    public void update() {
        System.out.println("收到通知"+ this);
    }
}
