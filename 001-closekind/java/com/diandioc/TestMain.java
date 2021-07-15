package com.diandioc;

import java.lang.reflect.Constructor;

public class TestMain {
    public static void main(String[] args) {
        Container container = new Container();  //此处完全由容器控制，BeanA BeanC被隔离，完全符合ocp开闭原则，主体易于扩展
        container.getBean();
    }
}
