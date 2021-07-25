package main.java.com.gamecli.gameelements.enemy;

import main.java.com.gamecli.gameelements.base.BaseGameObject;
import main.java.com.gamecli.util.GameUtil;

import java.awt.image.BufferedImage;

/**
 * @ProjectName: 23designpattern_java
 * @Package: main.java.com.test.gameelements
 * @ClassName: FootBall
 * @Author: chenyang
 * @Description: 足球类
 * @Date: 2021/7/19 11:41 下午
 * @Version: 1.0
 */
public class Stone extends BaseGameObject {
    public Stone() {

        this.image = GameUtil.getToTransparentImages("images/stone.png");
        this.width = 64;
        this.height =64;
    }


}
