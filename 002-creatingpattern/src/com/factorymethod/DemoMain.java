package com.factorymethod;

/**
 * 工厂方法Demo
 */
public class DemoMain {
    public static void main(String[] args) {
        Creator creator = new ConcreateCreator();
        Product product = creator.factory(ConcreateProduct.class);
        product.method1();
        product.method2();
        System.out.println("============");
        Creator creator1 = new ConcreateOtherCreator();
        Product product1 = creator1.factory("1");
        product1.method1();
        product1.method2();
    }
}
