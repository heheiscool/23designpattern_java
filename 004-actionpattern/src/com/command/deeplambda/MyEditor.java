package com.command.deeplambda;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.command.deeplambda
 * @ClassName: MyEditor
 * @Author: chenyang
 * @Description:
 * @Date: 2021/3/10 12:36 AM
 * @Version: 1.0
 */
public class MyEditor implements Editor {
    @Override
    public void save() {
        System.out.println("保存");
    }

    @Override
    public void open() {
        System.out.println("打开");
    }

    @Override
    public void close() {
        System.out.println("关闭");
    }
}
