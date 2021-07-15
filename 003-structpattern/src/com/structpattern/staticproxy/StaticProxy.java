package com.structpattern.staticproxy;

public class StaticProxy implements MapperInterface{
    //以被代理角色接口作为注入参数
    private MapperInterface mapperInterface;

    public StaticProxy(MapperInterface mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

//    public int doSave(User user){
//
//        System.out.println("-----------获取连接----------");
//        System.out.println("-----------提交事务----------");
//        int status = mapperInterface.save(user);
//        System.out.println("-----------关闭连接----------");
//        return status;
//    }

    @Override
    public int save(User user) {
        System.out.println("-----------获取连接----------");
        System.out.println("-----------提交事务----------");
        int status = mapperInterface.save(user);
        System.out.println("-----------关闭连接----------");
        return status;
    }
}
