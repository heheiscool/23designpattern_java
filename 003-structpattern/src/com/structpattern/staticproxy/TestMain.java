package com.structpattern.staticproxy;

public class TestMain {
    public static void main(String[] args) {
        User user = new User(1,"honghong","女");
        //初始化被代理对象
        TeacherMapper teacherMapper = new TeacherMapper();
        teacherMapper.save(user);
        StudentMapper studentMapper = new StudentMapper();
        studentMapper.save(user);


        //初始化代理，将需要被代理的角色注入代理中
        StaticProxy staticProxyTeacher = new StaticProxy(teacherMapper);
        //通过代理调用相应的方法
        staticProxyTeacher.save(user);

        System.out.println("\n++++++++++++++++++++++++++++\n");

        StaticProxy staticProxyStudent = new StaticProxy(studentMapper);
        //通过代理调用相应的方法
        staticProxyStudent.save(user);





    }
}
