package com.springioc.injection.service;

import com.springioc.injection.dao.InjectionDao;

public class InjectionServiceImpl implements InjectionService {
    private InjectionDao injectionDao;

    //传参注入
    public void setInjectionDao(InjectionDao injectionDao) {
        this.injectionDao = injectionDao;
    }
    //构造器注入
    public InjectionServiceImpl(InjectionDao injectionDao){
        this.injectionDao = injectionDao;
    }
    @Override
    public void save(String arg) {
        System.out.println("Service接受参数："+arg);
        arg = arg + this.hashCode();
        injectionDao.save(arg);
    }
}
