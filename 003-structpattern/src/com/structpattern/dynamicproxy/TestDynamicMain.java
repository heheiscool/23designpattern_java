package com.structpattern.dynamicproxy;

public class TestDynamicMain {
    public static void main(String[] args) {
        User user = new User(1,"honghong","女");

        DynamicProxy proxy = new DynamicProxy();

        StudentMapper studentMapper = new StudentMapper();
        MapperInterface mapperInterfaceStudent = proxy.bind(studentMapper);
        mapperInterfaceStudent.save(user);
        System.out.println("\n++++++++++++++++++++++++++++\n");



    }
}
