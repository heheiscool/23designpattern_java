package com.abstractfactory;

/**
 * 抽象工厂Demo
 */
public class DemoMain {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new TopFactory();
        ICar iCar = abstractFactory.createCar();
        iCar.show();
        IBus iBus = abstractFactory.createBus();
        iBus.show();
    }
}
