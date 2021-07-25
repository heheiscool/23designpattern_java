package main.java.com.gamecli.util;


import main.java.com.gamecli.config.Constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @ProjectName: 23designpattern_java
 * @Package: game.tetris
 * @ClassName: GameUtil
 * @Author: chenyang
 * @Description: 游戏工具类
 * @Date: 2021/7/15 11:15 下午
 * @Version: 1.0
 */
public class GameUtil {

    private GameUtil() {

    }

    /**
     * 获取图片资源
     * @param path
     * @return
     */
    public static Image getImages(String path){
        BufferedImage bufferedImage = null;
        try {
            URL url = GameUtil.class.getClassLoader().getResource(path);
            bufferedImage = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bufferedImage;
    }

    /**
     * 获取去掉元素背景的图
     * @param path
     * @return
     */
    public static Image getToTransparentImages(String path){
        BufferedImage bufferedImage = null;
        try {
            URL url = GameUtil.class.getClassLoader().getResource(path);
            bufferedImage = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int alpha = 255;
        String removeRgb = null;
        // 遍历Y轴的像素
        for (int y = bufferedImage.getMinY(); y < bufferedImage.getHeight(); y++) {
            // 遍历X轴的像素
            for (int x = bufferedImage.getMinX(); x < bufferedImage.getWidth(); x++) {
                int rgb = bufferedImage.getRGB(x, y);
                // 取图片边缘颜色作为对比对象
                if (y == bufferedImage.getMinY() && x == bufferedImage.getMinX()) {
                    removeRgb = convertRgb(rgb);
                }
                // 设置为透明背景
                if (removeRgb.equals(convertRgb(rgb))) {
                    alpha = 0;
                } else {
                    alpha = 255;
                }
                rgb = (alpha << 24) | (rgb & 0x00ffffff);
                System.out.println(Integer.toHexString(rgb));
                bufferedImage.setRGB(x, y, rgb);
            }
        }

        return bufferedImage;
    }


    /**
     * 转RGB
     * @param color
     * @return
     */
    public static String convertRgb(int color) {
        int red = (color & 0xff0000) >> 16;// 获取color(RGB)中R位
        int green = (color & 0x00ff00) >> 8;// 获取color(RGB)中G位
        int blue = (color & 0x0000ff);// 获取color(RGB)中B位
        return red + "," + green + "," + blue;
    }



    /**
     * 开启一个 指定频率的定时器
     *
     * @param period
     * @param t
     */
    public static void task(long period,ITime t){
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(Constants.TIMER_STOP_ON_OFF){
                    timer.cancel();
                    return;
                }
                t.run();
            }
        };

        timer.schedule(timerTask,0,period);


    }
}