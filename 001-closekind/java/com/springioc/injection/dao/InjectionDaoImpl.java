package com.springioc.injection.dao;

public class InjectionDaoImpl implements InjectionDao {
    @Override
    public void save(String arg) {
        //模拟数据库保存操作
        System.out.println("保存数据："+arg);
    }
}
