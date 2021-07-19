package com.snakegame;

import javax.swing.*;
/**
 * @ProjectName: 23designpattern_java
 * @Package: com.snakegame
 * @ClassName: MainApp
 * @Author: chenyang
 * @Description: 游戏初始化界面
 * @Date: 2021/7/19 12:05 上午
 * @Version: 1.0
 */
public class MainApp {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SnakeFrame frame = new SnakeFrame();
        frame.setSize(350,350);
        frame.setResizable(false);
        frame.setLocation(330,220);
        frame.setTitle("贪吃蛇");
        frame.setVisible(true);
    }
}
