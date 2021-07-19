package game.cli.gameelements;

import game.cli.config.Constants;

import java.awt.*;

/**
 * @ProjectName: 23designpattern_java
 * @Package: game.tetris
 * @ClassName: Shell
 * @Author: chenyang
 * @Description: 炮弹类
 * @Date: 2021/7/16 6:07 下午
 * @Version: 1.0
 */
public class Shell extends GameObject {
    double degree;

    public Shell() {
        degree = Math.random()*Math.PI*2;
        x = 200;
        y = 200;
        width = 10;
        height =10;
        speed = 5;
    }


    @Override
    public void drawMySelf(Graphics g){
        // 创建 Graphics 的副本, 需要改变 Graphics 的参数,
        // 这里必须使用副本, 避免影响到 Graphics 原有的设置
        Graphics2D graphics = (Graphics2D) g.create();

        Color color = graphics.getColor();
        graphics.setColor(Color.yellow);
        graphics.fillOval((int)x,(int)y,width,height);
        x += speed * Math.cos(degree);
        y += speed * Math.sin(degree);

        //遇到边反弹
        if(y > Constants.bgHeight-height || y<0){
            degree = -degree;
        }
        if(x < 0 || x > Constants.bgWidth-width){
            degree = Math.PI-degree;
        }
        graphics.setColor(color);

        //销毁创建对副本
        graphics.dispose();
    }
}
