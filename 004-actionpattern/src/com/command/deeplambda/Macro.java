package com.command.deeplambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.command.deeplambda
 * @ClassName: Macro
 * @Author: chenyang
 * @Description: 保存所有操作，然后执行所有操作
 * @Date: 2021/3/9 11:41 PM
 * @Version: 1.0
 */
public class Macro {
    private final List<Action> actions;

    public Macro() {
        this.actions = new ArrayList<>();
    }

    public void record(Action action){
        actions.add(action);
    }

    public void run(){
        actions.forEach(Action::perform);
    }


}
