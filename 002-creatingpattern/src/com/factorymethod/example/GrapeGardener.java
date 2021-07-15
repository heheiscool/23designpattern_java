package com.factorymethod.example;

public class GrapeGardener implements FruitGardener {

    @Override
    public Fruit factory() {
        return new Grape();
    }
}
