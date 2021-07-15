package com.observer.gper;

import java.util.Observable;
import java.util.Observer;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.observer.gper
 * @ClassName: Teacher
 * @Author: chenyang
 * @Description: 观察者
 * @Date: 2021/3/18 3:46 PM
 * @Version: 1.0
 */
public class Teacher implements Observer {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        GPer gPer = (GPer) o;
        Question question = (Question) arg;
        System.out.println("==================");
        System.out.println(name+"老师，您好！\n"+
                "您收到了一个来自"+gPer.getName()+
                "的提问，希望您解答，内容如下\n"+
                question.getContent()+"\n"+
                "提问者是："+question.getUserName());
    }
}
