package com.observer.basic;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.observer
 * @ClassName: ConcreteSubject
 * @Author: chenyang
 * @Description: 具体主题实现
 * @Date: 2021/1/7 12:34 PM
 * @Version: 1.0
 */
public class ConcreteSubject implements Subject {
    //定义一个动态数组
    private Vector<Observer> observers = new Vector<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void dettach(Observer observer) {
        observers.remove(observer);
    }

    //通知所有登记过的观察者
    @Override
    public void notifyObserver() {
        for(Observer o:observers){
            o.update();
        }
    }

    //返回观察者集合的Enumeration
    public Enumeration<Observer> observerEnumeration(){
        return observers.elements();
    }

    //业务方法，改变状态
    public void change(){
        this.notifyObserver();
    }
}
