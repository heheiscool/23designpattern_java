package com.factorymethod.example;

public class AppleGardener implements FruitGardener {

    @Override
    public Fruit factory() {
        return new Apple();
    }
}
