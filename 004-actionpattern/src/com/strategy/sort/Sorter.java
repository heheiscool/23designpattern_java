package com.strategy.sort;

import java.util.ArrayList;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.strategy.sort
 * @ClassName: Sorter
 * @Author: chenyang
 * @Description:
 * @Date: 2021/2/26 4:16 PM
 * @Version: 1.0
 */
public class Sorter<T> {
    protected SortStragy sort;

    public Sorter(SortStragy sort) {
        this.sort = sort;
    }

    public ArrayList<T> sort(ArrayList<T> list){
        return sort.sort(list);
    }
}
