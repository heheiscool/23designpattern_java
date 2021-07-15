package com.interfaces;

import static org.junit.jupiter.api.Assertions.*;

import com.springbean.BeanScope;
import com.springioc.injection.service.InjectionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

//@RunWith(BlockJUnit4ClassRunner.class)
public class OneInterfaceImpTest extends UnitTestBase{
    public OneInterfaceImpTest(){
        super("classpath:applicationContext.xml");
    }

    //第一个bean的调试，通过上线文索引初始化bean
    @Test
    public void hello() {
        OneInterface oneInterface = super.getBean("oneInterface");
        System.out.println(oneInterface.hello("asdfasdfasdfasdf"));
    }

    //通过注入的方式实例化bean(类)
    @Test
    public void SpringIocParamInjection(){
        InjectionService injectionService = super.getBean("injectionService");
        injectionService.save("使用传参注入的业务方式，这是要保存的数据");

    }
    //通过构造器注入方式实例化bean
    @Test
    public void SpringIocConstructorInjection(){
        InjectionService injectionService = super.getBean("injectionService");
        injectionService.save("使用构造器注入的业务方式，保存的数据");

    }

}