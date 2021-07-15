package com.command.command;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.command
 * @ClassName: TestMain
 * @Author: chenyang
 * @Description:
 * @Date: 2021/2/26 11:23 PM
 * @Version: 1.0
 */
public class CommandMain {
    public static void main(String[] args) {
        Reciever reciever = new Reciever();
        Command command = new ConcreteCommand(reciever);
        Invoker invoker = new Invoker(command);
        System.out.println("命令发起者调用");
        command.execute();
        System.out.println("invoke调用action");
        invoker.action();
    }
}
