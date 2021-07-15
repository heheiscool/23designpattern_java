package com.diandioc;

public class Container {
    public void getBean(){
        IC ic = new BeanC();
        BeanA beanA = new BeanA();
        beanA.setBeanC(ic);
        beanA.print();
    }
}
