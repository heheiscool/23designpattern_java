package com.observer.basic;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.observer
 * @ClassName: Subject
 * @Author: chenyang
 * @Description: 抽象主题
 * @Date: 2021/1/7 11:52 AM
 * @Version: 1.0
 */
public interface Subject {
    //登记一个观察者
    public void attach(Observer observer);
    //删除一个登记过的观察者
    public void dettach(Observer observer);
    //通知观察者
    public void notifyObserver();
}
