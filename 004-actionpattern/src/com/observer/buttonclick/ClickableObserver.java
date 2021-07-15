package com.observer.buttonclick;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.observer.buttonclick
 * @ClassName: ClickableObserer
 * @Author: chenyang
 * @Description: 可点击控件的单击事件观察者接口
 * @Date: 2021/1/7 4:13 PM
 * @Version: 1.0
 */
public interface ClickableObserver {
    //发生单机事件的操作
    void clicked(Clickable clickable);
}
