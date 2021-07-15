package com.command.deeplambda;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.command.deeplambda
 * @ClassName: Save
 * @Author: chenyang
 * @Description: 打开操作代理给Editor
 * @Date: 2021/3/9 11:21 PM
 * @Version: 1.0
 */
public class Open implements Action{
    private Editor editor;

    public Open(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.open();
    }
}
