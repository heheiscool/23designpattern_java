package com.builder.common;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.builder
 * @ClassName: Product
 * @Author: chenyang
 * @Description: 产品类角色，被创建的复杂对象，注入到实现类
 * @Date: 2020/12/26 9:04 AM
 * @Version: 1.0
 */
public class Product {
    public Product() {
        System.out.println("这里初始化了产品类");
    }

    @Override
    public String toString() {
        return "Product{}";
    }
}
