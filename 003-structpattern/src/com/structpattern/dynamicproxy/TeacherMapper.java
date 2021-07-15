package com.structpattern.dynamicproxy;

public class TeacherMapper implements MapperInterface {
    @Override
    public int save(User user) {
        System.out.println("-----------保存老师数据--------------");
        return 2;
    }
}
