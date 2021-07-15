package com.builder.common;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.builder
 * @ClassName: ConcreteBuilder
 * @Author: chenyang
 * @Description: builder实现类
 * @Date: 2020/12/26 9:26 AM
 * @Version: 1.0
 */
public class ConcreteBuilder implements Builder{
    private Product product = new Product();
    @Override
    public void setPart1() {
        System.out.println("组装product类的配件1");
    }

    @Override
    public void setPart2() {
        System.out.println("组装product类的配件2");
    }

    @Override
    public void setPart3() {
        System.out.println("组装product类的配件3");
    }

    @Override
    public Product builderProduct() {
        return product;
    }

}
