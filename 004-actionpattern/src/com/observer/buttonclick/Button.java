package com.observer.buttonclick;

import com.observer.buttonclick.Clickable;
import com.observer.buttonclick.ClickableObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.observer.basic
 * @ClassName: Button
 * @Author: chenyang
 * @Description: 按钮控件类，clickable接口的实现，被观察者的实现
 * @Date: 2021/1/7 4:16 PM
 * @Version: 1.0
 */
public class Button implements Clickable {
    //存储注册过的单击事件的观察者
    List<ClickableObserver> observers = new ArrayList<>();
    //按钮信息
    //颜色
    public String color;
    //坐标
    public int x,y;

    @Override
    public void click() {
        System.out.println("按钮被点击");
        //所有观察者的事件处理方法都出发
        for(int i = observers.size()-1;i>=0;i--){
            observers.get(i).clicked(this);
        }
    }

    @Override
    public void addClickableObserver(ClickableObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeClickableObserver(ClickableObserver observer) {
        observers.remove(observer);
    }

    @Override
    public String toString() {
        return "Button{" +
                "observers=" + observers +
                ", color='" + color + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
