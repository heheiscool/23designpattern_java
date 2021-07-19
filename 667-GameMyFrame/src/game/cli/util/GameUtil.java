package game.cli.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

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
}
