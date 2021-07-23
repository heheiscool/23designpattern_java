package main.java.com.test.gameelements;

import main.java.com.test.gameelements.base.GameObject;
import main.java.com.test.util.GameUtil;

/**
 * @ProjectName: 23designpattern_java
 * @Package: main.java.com.test.gameelements
 * @ClassName: FootBall
 * @Author: chenyang
 * @Description: 足球类
 * @Date: 2021/7/19 11:41 下午
 * @Version: 1.0
 */
public class FootBall extends GameObject {
    public FootBall() {
        this.image = GameUtil.getImages("images/football.gif");
        this.width = 30;
        this.height =30;
    }


}
