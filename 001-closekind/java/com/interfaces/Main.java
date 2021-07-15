package com.interfaces;

public class Main {
    public static void main(String[] args) {
        /**
         *面向接口编程，测试模块中使用bean实例化类
         */
        OneInterface oneInterface = new OneInterfaceImp();
        System.out.println(oneInterface.hello("hell world!"));
    }
}
