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

        //获取源图像的宽高
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        System.out.println(width+" "+height);
        //实例化一个同样大小的图片，并将type设为 BufferedImage.TYPE_4BYTE_ABGR，支持alpha通道的rgb图像
        BufferedImage resImage = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);

        double grayMean = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = bufferedImage.getRGB(i,j);
                int r = (0xff&rgb);
                int g = (0xff&(rgb>>8));
                int b = (0xff&(rgb>>16));
                //这是灰度值的计算公式
                grayMean += (r*0.299+g*0.587+b*0.114);
            }
        }
        //计算平均灰度
        grayMean = grayMean/(width*height);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = bufferedImage.getRGB(i,j);
                //一个int是32位,java中按abgr的顺序存储，即前8位是alpha，最后8位是r，所以可以通过下面的方式获取到rgb的值
                int r = (0xff&rgb);
                int g = (0xff&(rgb>>8));
                int b = (0xff&(rgb>>16));
                double gray = (r*0.299+g*0.587+b*0.114);
                //如果灰度值大于之前求的平均灰度值，则将其alpha设为0，下面准确写应该是rgb = r + (g << 8) + (b << 16) ＋ （0 << 24）;
                if (gray>grayMean){
                    rgb = r + (g << 8) + (b << 16);
                }
                resImage.setRGB(i,j,rgb);
            }
        }
        return resImage;
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