package com.observer.basic;

import com.observer.basic.ConcreteObserver;
import com.observer.basic.ConcreteSubject;
import com.observer.basic.Observer;
import com.observer.basic.Subject;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.observer
 * @ClassName: TestDemo
 * @Author: chenyang
 * @Description: 测试
 * @Date: 2021/1/7 1:02 PM
 * @Version: 1.0
 */
public class TestBasicDemo {
    public static void main(String[] args) {
        //创建一个主题对象，被观察对象
        Subject subject = new ConcreteSubject();
        Subject subject1 = new ConcreteSubject();
        //创建一个观察者
        Observer observer =new ConcreteObserver();
        subject.attach(observer);
        subject.notifyObserver();

        subject1.attach(observer);
        subject1.notifyObserver();
    }
}
