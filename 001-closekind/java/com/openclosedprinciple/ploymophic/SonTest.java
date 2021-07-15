package com.openclosedprinciple.ploymophic;

public class SonTest extends Test{
    public String book = "重新定义一个book实例变量隐藏父类变量";
    @Override
    public void test() {
        System.out.println("子类覆盖父类方法");
    }
    public void sub(){
        System.out.println("子类普通方法");
    }
}
