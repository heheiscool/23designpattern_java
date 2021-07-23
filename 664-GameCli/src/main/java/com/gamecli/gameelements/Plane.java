package main.java.com.test.gameelements;

import main.java.com.test.config.Constants;
import main.java.com.test.gameelements.base.GameObject;
import main.java.com.test.util.GameUtil;

/**
 * @ProjectName: 23designpattern_java
 * @Package: main.java.com.test.gameelements
 * @ClassName: Plane
 * @Author: chenyang
 * @Description: 飞机类
 * @Date: 2021/7/23 8:17 下午
 * @Version: 1.0
 */
public class Plane extends GameObject {
    public Plane() {
        this.image = GameUtil.getImages("images/plane.png");
        this.width = 38;
        this.height =32;
        this.x = Constants.bgWidth/2;
        this.y = Constants.bgHeight-this.getHeight();
    }
}
