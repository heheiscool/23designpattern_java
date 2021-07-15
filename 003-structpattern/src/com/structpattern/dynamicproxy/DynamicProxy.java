package com.structpattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

    //bind方法中的参数为：被代理的对象
   public <T> T bind(T t){

       /**
        * Proxy: 调用newProxyInstance方法后，可以得到加强版的代理对象
        * newProxyInstance中需要参数：
        * 1、类加载器
        * 2、获取被代理对象接口相关Class类信息
        */
       return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), new InvocationHandler() {

           /**
            * 重写对应的方法，将需要代理的动作写入该方法
            * method :目标方法
            * args: 目标方法中的参数
            *
            */
           @Override
           public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               System.out.println("-----------获取连接----------");
               System.out.println(method+"===");
               Integer i = 0;
               for (Object s:args
                    ) {
                   System.out.println("arg---"+ (i++) + s);
               }
               Object result = method.invoke(t,args);
               System.out.println("result" + result );
               System.out.println("-----------提交事务----------");
               System.out.println("-----------关闭连接----------");
               return result;
           }

       });
   }
}
