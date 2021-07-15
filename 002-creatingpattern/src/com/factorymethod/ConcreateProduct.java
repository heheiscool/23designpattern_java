package com.factorymethod;

public class ConcreateProduct implements Product {
    static {
        System.out.println("工厂方法模式");
    }
    @Override
    public void method1() {
        System.out.println("生产产品000");
    }

    @Override
    public void method2() {
        System.out.println("生产产品111");
    }
}
