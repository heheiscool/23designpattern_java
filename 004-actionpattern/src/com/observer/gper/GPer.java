package com.observer.gper;

import java.util.Observable;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.observer.gper
 * @ClassName: GPer
 * @Author: chenyang
 * @Description: 发布者(被观察者)主题定义，实现JDK自带主题接口
 * @Date: 2021/3/18 3:09 PM
 * @Version: 1.0
 */
public class GPer extends Observable {
    private String name = "GPer生态圈";
    private static GPer gPer = null;
    GPer(){}

    //单例模式
    public static GPer getInstance(){
        if(gPer==null){
            gPer = new GPer();
        }
        return gPer;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Question question){
        System.out.println(question.getUserName()+"在"+this.name+"提交了一个问题.");
        setChanged();
        notifyObservers(question);
    }
}
