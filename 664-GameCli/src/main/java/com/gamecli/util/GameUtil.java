package main.java.com.test.util;


import main.java.com.test.config.Constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
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