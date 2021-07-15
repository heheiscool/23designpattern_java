package com.reflectiondemo;

import java.lang.reflect.*;
public class DemoA {
/**
 *  反射功能Demo
 **/
    int m;
    public DemoA(){
        System.out.println("This is A");
    }
    public DemoA(Integer i) {
        System.out.println("This is A"+i);
    }
    public DemoA(Integer i,String s) {
        System.out.println("This is A"+ i +","+ s);
    }
    public void fun1(){
        System.out.println("This is A.fun1");
    }
    public void fun2(){
        System.out.println("This is A.fun2");

    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class aClass = Class.forName("com.reflectiondemo.DemoA");
        System.out.println("获取构造函数如下：");
        //获取构造函数
        Constructor constructor[] = aClass.getConstructors();
        for(int i=0;i<constructor.length;i++){
            System.out.println("第"+i+"个构造函数"+constructor[i].toString()+'\n');
        }
        System.out.println();
        //获取所有变量
        System.out.println("成员变量如下:");
        Field field[] = aClass.getDeclaredFields();
        for(int i=0;i<field.length;i++){
            System.out.println(field[i].toString()+"\n");
        }
        System.out.println();
        //获取所有的方法
        System.out.println("成员方法如下:");
        Method method[] = aClass.getDeclaredMethods();
        for (int i=0;i<method.length;i++){
            System.out.println(method[i].toString()+"\n");
        }
        System.out.println("=================");
        //利用无参获取构造方法类getConstructs或有参getConstructor实例化
        System.out.println("有参数构造方法实例化");
        Constructor c = aClass.getConstructor();
        DemoA demoA = (DemoA) c.newInstance();
        demoA.fun1();
        demoA.fun2();
        Constructor c1 = aClass.getConstructor(new Class[]{Integer.class,String.class});
        DemoA demoA1 = (DemoA) c1.newInstance(new Object[]{10,"hello"});
        demoA1.fun1();
        demoA1.fun2();
        System.out.println("有参数构造方法实例化");
        //利用无参获取构造方法类getConstructs或有参getConstructor实例化
        System.out.println("有参数构造方法实例化");
        constructor[0].newInstance(new Object[]{10,"cool"});
        constructor[1].newInstance(new Object[]{10});
        constructor[2].newInstance();
    }
}
