package com.factorymethod.example;

public class DemoMain {
    public static void main(String[] args) {
        FruitGardener appleGardener = new AppleGardener();
        Fruit apple = appleGardener.factory();
        apple.grow();
        apple.harvest();
        apple.plant();

        FruitGardener grapeGardener = new GrapeGardener();
        Fruit grape = grapeGardener.factory();
        grape.plant();
        grape.harvest();
        grape.grow();
    }
}
