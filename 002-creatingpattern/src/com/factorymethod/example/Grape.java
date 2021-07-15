package com.factorymethod.example;

public class Grape implements Fruit {

    private int treeAge;

    public int getTreeAge(){
        return treeAge;
    }

    public void setTreeAge(int treeAge) {
        this.treeAge = treeAge;
    }

    @Override
    public void grow() {
        System.out.println("葡萄正在生长...");
    }

    @Override
    public void harvest() {
        System.out.println("收获葡萄...");
    }

    @Override
    public void plant() {
        System.out.println("栽种葡萄...");
    }
}
