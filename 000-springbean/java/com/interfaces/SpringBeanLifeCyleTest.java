package com.interfaces;

import com.springbean.BeanLifeCycle;
import com.springbean.BeanScope;
import org.junit.Test;

//@RunWith(BlockJUnit4ClassRunner.class)
public class SpringBeanLifeCyleTest extends UnitTestBase{
    public SpringBeanLifeCyleTest(){
        super("classpath:spring-lifecycle.xml");
    }

    //通过配置上线文中bean的属性决定bean的是单例模式还是多例模式
    @Test
    public void SpringBean(){
        BeanLifeCycle beanLifeCycle = super.getBean("beanLifeCycle");

    }
}