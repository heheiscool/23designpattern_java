package main.java.com.gamecli.gameelements.base;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ProjectName: 23designpattern_java
 * @Package: main.java.com.gamecli.gameelements.base
 * @ClassName: BaseService
 * @Author: chenyang
 * @Description: 服务接口实现中间抽象层
 * @Date: 2021/7/24 8:28 下午
 * @Version: 1.0
 */
public abstract class BaseService<T> implements IService<T>{
    private CopyOnWriteArrayList<T> elementList = new CopyOnWriteArrayList<>();//元素列表

    @Override
    public void init() {
        elementList.clear();
    }

    @Override
    public void add(T element) {
        this.elementList.add(element);
    }

    @Override
    public void remove(T element) {
        this.elementList.remove(element);
    }

    @Override
    public CopyOnWriteArrayList<T> getElementList() {
        return elementList;
    }

}
