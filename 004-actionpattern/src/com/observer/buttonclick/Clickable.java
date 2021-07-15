package com.observer.buttonclick;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.observer.buttonclick
 * @ClassName: Clickable
 * @Author: chenyang
 * @Description: 可以点击控件功能方法抽象,被观察者接口
 * @Date: 2021/1/7 4:06 PM
 * @Version: 1.0
 */
public interface Clickable {
    //点击
    void click();
    //添加点击事件观察者
    void addClickableObserver(ClickableObserver observer);
    //移除点击事件观察者
    void removeClickableObserver(ClickableObserver observer);
}
