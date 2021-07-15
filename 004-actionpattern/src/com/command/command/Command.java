package com.command.command;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.command
 * @ClassName: Cmmand
 * @Author: chenyang
 * @Description: 命令接口角色
 * @Date: 2021/2/26 5:59 PM
 * @Version: 1.0
 */
public interface Command {
    void execute();
    void undo();
    void redo();
}
