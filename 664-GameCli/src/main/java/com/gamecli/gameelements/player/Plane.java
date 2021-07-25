package main.java.com.gamecli.gameelements.player;

import main.java.com.gamecli.config.Constants;
import main.java.com.gamecli.gameelements.base.BaseGameObject;
import main.java.com.gamecli.util.GameUtil;

/**
 * @ProjectName: 23designpattern_java
 * @Package: main.java.com.test.gameelements
 * @ClassName: Plane
 * @Author: chenyang
 * @Description: 飞机类
 * @Date: 2021/7/23 8:17 下午
 * @Version: 1.0
 */
public class Plane extends BaseGameObject {
    public Plane() {
        this.image = GameUtil.getImages("images/plane_02.png");
        this.width = 53;
        this.height =40;
        this.x = Constants.bgWidth/2;
        this.y = Constants.bgHeight-this.getHeight();
    }
}
