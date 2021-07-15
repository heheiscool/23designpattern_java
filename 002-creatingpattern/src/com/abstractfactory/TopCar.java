package com.abstractfactory;

public class TopCar implements ICar {
    @Override
    public void show() {
        System.out.println("高档小车...");
    }
}
