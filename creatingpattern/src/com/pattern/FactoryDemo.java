package com.pattern;

public class FactoryDemo {
    public static void main(String[] args) {
        Creator creator = new ConcreateCreator();
        Product product = creator.factory(ConcreateProduct.class);
        product.method1();
        product.method2();
    }
}
