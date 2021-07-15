package com.builder.common;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.builder
 * @ClassName: Director
 * @Author: chenyang
 * @Description: 导演角色，负责创建流程，起到了封装作用
 * @Date: 2020/12/26 9:27 AM
 * @Version: 1.0
 */
public class Director {
    //注入创建类
    private Builder builder = new ConcreteBuilder();
    //创建过程
    public Product build(){
        builder.setPart1();
        builder.setPart2();
        builder.setPart3();
        return builder.builderProduct();
    }
}
