package com.interfaces;

import com.springbean.BeanScope;
import com.springioc.injection.service.InjectionService;
import org.junit.Test;

//@RunWith(BlockJUnit4ClassRunner.class)
public class SpringBeanTest extends UnitTestBase{
    public SpringBeanTest(){
        super("classpath:spring-bean.xml");
    }

    //通过配置上线文中bean的属性决定bean的是单例模式还是多例模式
    @Test
    public void SpringBeanSingleton(){
        BeanScope beanScope = super.getBean("beanScope");
        beanScope.say();

        BeanScope beanScope1 = super.getBean("beanScope");
        beanScope1.say();
    }
}