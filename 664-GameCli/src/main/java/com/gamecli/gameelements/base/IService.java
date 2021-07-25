package main.java.com.gamecli.gameelements.base;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ProjectName: 23designpattern_java
 * @Package: main.java.com.gamecli.gameelements.base
 * @ClassName: IService
 * @Author: chenyang
 * @Description: 业务接口，细化各元素业务逻辑颗粒度
 * @Date: 2021/7/24 5:03 下午
 * @Version: 1.0
 */
public interface IService<T> extends IDraw{
    /**
     * 初始化清除列表元素
     */
    void init();

    /**
     * 添加
     *
     * @param element
     */
    void add(T element);

    /**
     * 移除
     *
     * @param element
     */
    void remove(T element);

    /**
     * 获取元素列表
     *
     * @return
     */
    CopyOnWriteArrayList<T> getElementList();
}
