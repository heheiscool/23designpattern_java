package com.com.simplefactory;

public class DemoMain {
    /**
     * 简单工厂Demo
     * @param args
     */
    public static void main(String[] args) {
        ICar iCar = null;
        iCar = CarSimpleFactory.create("TOP");
        iCar.product();
        System.out.println("================");
        iCar = CarOtherSimpleFactory.create("TOP");
        iCar.product();
    }
}
