package com.builder.common;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.builder
 * @ClassName: TestMain
 * @Author: chenyang
 * @Description: 测试
 * @Date: 2020/12/26 9:50 AM
 * @Version: 1.0
 */
public class TestMain {
    public static void main(String[] args) {
        Director director = new Director();
        Product product = director.build();
        System.out.println(product.toString());
    }
}
