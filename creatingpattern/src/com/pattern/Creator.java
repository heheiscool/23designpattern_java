package com.pattern;

public interface Creator {
    /**
    *创建工厂方法
     */
    public <T extends Product> T factory(Class<T> tClass);
}
