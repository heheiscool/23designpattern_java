package com.command.deeplambda;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.command.deeplambda
 * @ClassName: Save
 * @Author: chenyang
 * @Description: 关闭操作代理给Editor
 * @Date: 2021/3/9 11:21 PM
 * @Version: 1.0
 */
public class Close implements Action{
    private Editor editor;

    public Close(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.close();
    }
}
