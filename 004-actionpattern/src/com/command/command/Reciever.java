package com.command.command;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.command
 * @ClassName: Reciever
 * @Author: chenyang
 * @Description:
 * @Date: 2021/2/26 11:01 PM
 * @Version: 1.0
 */
public class Reciever {
    //接收者接收命令后完成对应的某个动作
    public void action(String commandName){
        System.out.println(commandName+"执行动作！");
    }
}
