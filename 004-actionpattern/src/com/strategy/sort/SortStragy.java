package com.strategy.sort;

import java.util.ArrayList;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.strategy.sort
 * @ClassName: SortStragy
 * @Author: chenyang
 * @Description: 策略接口
 * @Date: 2021/2/26 3:41 PM
 * @Version: 1.0
 */
public interface SortStragy<T> {
    ArrayList<T> sort(ArrayList<T> list);
}
