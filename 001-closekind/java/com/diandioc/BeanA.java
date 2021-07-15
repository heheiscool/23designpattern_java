package com.diandioc;

public class BeanA {
    private IC ic;

    public void print(){    //A依赖C，将C注入A
        System.out.println("已被注入了");
        ic.print();
    }

    public void setBeanC(IC ic) {
        this.ic = ic;
    }
}
