package com.pattern;

public class ConcreateProduct implements Product {
    @Override
    public void method1() {
        System.out.println("生产产品000");
    }

    @Override
    public void method2() {
        System.out.println("生产产品111");
    }
}
