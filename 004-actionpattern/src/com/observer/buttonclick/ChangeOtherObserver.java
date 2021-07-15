package com.observer.buttonclick;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.observer.buttonclick
 * @ClassName: ChangeColorObserver
 * @Author: chenyang
 * @Description: 其他业务操作的观察者
 * @Date: 2021/1/7 4:54 PM
 * @Version: 1.0
 */
public class ChangeOtherObserver implements ClickableObserver {
    @Override
    public void clicked(Clickable clickable) {
        System.out.println("执行其他操作...");
    }
}
