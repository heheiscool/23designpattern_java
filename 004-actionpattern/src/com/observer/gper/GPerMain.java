package com.observer.gper;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.observer.gper
 * @ClassName: GPerMain
 * @Author: chenyang
 * @Description: 测试入口
 * @Date: 2021/3/18 3:51 PM
 * @Version: 1.0
 */
public class GPerMain {
    public static void main(String[] args) {
        GPer gPer = GPer.getInstance();
//        GPer gPer = new GPer();
        Teacher tom = new Teacher("Tom");
        Teacher jerry = new Teacher("Jerry");

        gPer.addObserver(tom);
        gPer.addObserver(jerry);

        Question question = new Question();
        question.setUserName("王麻子");
        question.setContent("能否讲下观察者模式");

        gPer.publishQuestion(question);

    }
}
