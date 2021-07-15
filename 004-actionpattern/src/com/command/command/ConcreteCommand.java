package com.command.command;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.command
 * @ClassName: ConcreteCommand
 * @Author: chenyang
 * @Description: 命令实现者也即是命令发起者
 * @Date: 2021/2/26 11:14 PM
 * @Version: 1.0
 */
public class ConcreteCommand implements Command{
    private Reciever reciever;

    public ConcreteCommand(Reciever reciever) {
        this.reciever = reciever;
    }


    @Override
    public void execute() { //转发接收者action方法
        reciever.action("excute");
    }


    @Override
    public void undo() {
        System.out.println("撤销执行命令!");
    }

    @Override
    public void redo() {
        System.out.println("返回执行命令!");
    }
}
