package com.springbean;

public class BeanLifeCycle {
    public void start(){      //初始化bean配置，只针对bean
        System.out.println("Bean start...");
    }

    public void stop(){      //销毁bean，只针对bean
        System.out.println("Bean stop...");
    }
}
