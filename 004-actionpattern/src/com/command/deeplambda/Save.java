package com.command.deeplambda;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.command.deeplambda
 * @ClassName: Save
 * @Author: chenyang
 * @Description: 保存操作代理给Editor
 * @Date: 2021/3/9 11:21 PM
 * @Version: 1.0
 */
public class Save implements Action{
    private Editor editor;

    public Save(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.save();
    }
}
