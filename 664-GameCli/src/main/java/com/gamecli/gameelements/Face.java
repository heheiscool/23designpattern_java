package main.java.com.test.gameelements;

import main.java.com.test.config.Constants;
import main.java.com.test.gameelements.base.GameObject;
import main.java.com.test.util.GameUtil;

/**
 * @ProjectName: 23designpattern_java
 * @Package: main.java.com.test.gameelements
 * @ClassName: Face
 * @Author: chenyang
 * @Description: 小人头图
 * @Date: 2021/7/20 8:48 上午
 * @Version: 1.0
 */
public class Face extends GameObject {
    public Face() {
        //以下的路径方式不适合模块目录？
        //Image image = new ImageIcon("664-GameCli/src/main/resources/athlete.gif").getImage();
         this.image = GameUtil.getImages("images/athlete.gif");
         this.width = 20;
         this.height = 20;
         this.x = Constants.bgWidth/2;
         this.y = Constants.bgHeight-this.getHeight();
    }
}
