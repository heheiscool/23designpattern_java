package com.observer.buttonclick;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.observer.buttonclick
 * @ClassName: ChangeColorObserver
 * @Author: chenyang
 * @Description: 修改按钮颜色的观察者
 * @Date: 2021/1/7 4:54 PM
 * @Version: 1.0
 */
public class ChangePositionObserver implements ClickableObserver {
    @Override
    public void clicked(Clickable clickable) {
        Button button = (Button) clickable;
        button.x = 100;
        button.y = 100;
    }
}
