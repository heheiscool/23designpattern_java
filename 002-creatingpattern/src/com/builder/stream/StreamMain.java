package com.builder.stream;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.builder.stream
 * @ClassName: StreamMain
 * @Author: chenyang
 * @Description: 测试类
 * @Date: 2021/3/13 10:13 AM
 * @Version: 1.0
 */
public class StreamMain {
    private void test(Product product){
        System.out.println("购买了一个" + product.getName());
    }
    public static void main(String[] args) {
        CourseBuilder builder = new CourseBuilder().addName("设计模式").addPpt("PPT演示").addNote("课程笔记").addVideo("视频回放").addHomework("[课后作业]");
        System.out.println(builder.builder());
        //
        System.out.println("匿名内部类");
        StreamMain streamMain = new StreamMain();
        streamMain.test(new Product() {
            @Override
            public double getPrice() {
                return 110;
            }

            @Override
            public String getName() {
                return "测试产品";
            }
        });
    }
}

interface Product{
    double getPrice();
    String getName();
}