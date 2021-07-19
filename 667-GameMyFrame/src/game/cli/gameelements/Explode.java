package game.cli.gameelements;

import game.cli.util.GameUtil;

import java.awt.*;

/**
 * @ProjectName: 23designpattern_java
 * @Package: game.tetris
 * @ClassName: Explode
 * @Author: chenyang
 * @Description: 爆炸类
 * @Date: 2021/7/16 8:17 下午
 * @Version: 1.0
 */
public class Explode extends GameObject {
    public static Image[] images = new Image[16];
    static {
        for(int i=0;i<16;i++){
            images[i] = GameUtil.getImages("images/explode/e"+(i+1)+".gif");
        }
    }
    int count;


    //因为onpain每40ms会重新绘制一次
    @Override
    public void drawMySelf(Graphics g) {
        // 创建 Graphics 的副本, 需要改变 Graphics 的参数,
        // 这里必须使用副本, 避免影响到 Graphics 原有的设置
        Graphics2D graphics = (Graphics2D) g.create();
        if(count<=15){
            graphics.drawImage(images[count],(int)x,(int)y,null);
            count++;
        }
        graphics.dispose();
    }

    public Explode(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
