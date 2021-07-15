package com.factorymethod;

public interface Creator {
    /**
    *创建工厂方法
     */
    public <T extends Product> T factory(Class<T> tClass);
    public <T extends Product> T factory(String productType);

}
