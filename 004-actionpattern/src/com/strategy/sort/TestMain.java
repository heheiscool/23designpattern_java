package com.strategy.sort;

import java.util.ArrayList;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.strategy.sort
 * @ClassName: TestMain
 * @Author: chenyang
 * @Description:
 * @Date: 2021/2/26 4:28 PM
 * @Version: 1.0
 */
public class TestMain {
    public static void main(String[] args) {
        //将排序方法和排序对象完全解耦
        ArrayList<String> list = new ArrayList<>();
        list.add("1213123");
        list.add("444");
        list.add("77777");
        Sorter sorter = new Sorter(new BubbleSort());
        Sorter sorter1 = new Sorter(new QuickSort());
        sorter.sort(list);
        sorter1.sort(list);
    }
}
