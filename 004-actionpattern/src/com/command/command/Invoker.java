package com.command.command;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.command
 * @ClassName: Invoker
 * @Author: chenyang
 * @Description: 调用者/请求者--命令的管理类
 * @Date: 2021/2/26 11:06 PM
 * @Version: 1.0
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(){
        this.command.execute();
    }
}
