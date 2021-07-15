package com.openclosedprinciple.ploymophic;

public class Test {
    public int book = 6;
    {
        System.out.println("==="+book);
    }
    public void base(){
        System.out.println("父类普通方法");
    }
    public void test(){
        System.out.println("父类被覆盖的方法");
    }
}
