package com.observer.buttonclick;

import com.observer.buttonclick.Button;
import com.observer.buttonclick.ChangeColorObserver;
import com.observer.buttonclick.ChangeOtherObserver;
import com.observer.buttonclick.ChangePositionObserver;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.observer
 * @ClassName: TestButtonDemo
 * @Author: chenyang
 * @Description: 测试类
 * @Date: 2021/1/7 5:10 PM
 * @Version: 1.0
 */
public class TestButtonDemo {
    public static void main(String[] args) {
        Button button = new Button();
        button.color = "白色";
        button.x = 0;
        button.y = 0;
        button.addClickableObserver(new ChangeColorObserver());
        button.addClickableObserver(new ChangeOtherObserver());
        button.addClickableObserver(new ChangePositionObserver());
        button.click();
        System.out.println(button);
    }
}
