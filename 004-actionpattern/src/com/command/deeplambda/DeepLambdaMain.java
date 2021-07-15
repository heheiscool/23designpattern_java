package com.command.deeplambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.command.deeplambda
 * @ClassName: DeepLambdaMain
 * @Author: chenyang
 * @Description:
 * @Date: 2021/3/10 12:38 AM
 * @Version: 1.0
 */
public class DeepLambdaMain {
    Runnable r1 = () -> { System.out.println(this); };
    Runnable r2 = () -> { System.out.println(toString()); };
    public static void main(String[] args) {
        System.out.println("----------Sream的用法-----------");
        List<String> list = Stream.of("a","b","c").collect(Collectors.toList());
//        assert(Arrays.asList("a","g","c").equals(list));
        for (String s:list
             ) {
            System.out.println(s);
        }
        for (String s:Arrays.asList("a","g","c")){
            System.out.println(s);
        }
        Macro macro = new Macro();
        Editor editor =new MyEditor();  //editor是Editor的一个实现
//        macro.record(new Save(editor));
//        macro.record(new Open(editor));
//        macro.record(new Close(editor));
        System.out.println("-----------匿名函数的写法----------");
        macro.record(new Action(){
            @Override
            public void perform() {
                editor.save();
            }
        });
        System.out.println("---------lambda表达式写法---------");
        macro.record(()->editor.close());
        System.out.println("--------引用写法-----------------");
        macro.record(editor::open);

        macro.run();

        System.out.println("--------验证闭包中的this就是类对应的this--------");
        new DeepLambdaMain().r1.run();
        new DeepLambdaMain().r2.run();



    }
    public String toString() { return "Hello Hoolee"; }
}
