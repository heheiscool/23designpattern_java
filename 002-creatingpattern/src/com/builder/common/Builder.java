package com.builder.common;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.builder
 * @ClassName: Builder
 * @Author: chenyang
 * @Description: 定义创建抽象接口
 * @Date: 2020/12/26 9:04 AM
 * @Version: 1.0
 */
public interface Builder {
    void setPart1();
    void setPart2();
    void setPart3();
    //创建产品
    Product builderProduct();
}
