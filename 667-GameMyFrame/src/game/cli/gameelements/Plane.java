package game.cli.gameelements;

import game.cli.config.Constants;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @ProjectName: 23designpattern_java
 * @Package: game.tetris
 * @ClassName: Plane
 * @Author: chenyang
 * @Description: 飞机类
 * @Date: 2021/7/16 1:12 下午
 * @Version: 1.0
 */
public class Plane extends GameObject {
    public boolean left = false,up = false,down = false,right = false;
    public boolean live = true;
    //按下键改变方向值
    public void addDirection(KeyEvent event){
        if(live) {
            switch (event.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    left = true;
                    break;
                case KeyEvent.VK_UP:
                    up = true;
                    break;
                case KeyEvent.VK_DOWN:
                    down = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    right = true;
                    break;
                case KeyEvent.VK_A:
                    left = true;
                    break;
                case KeyEvent.VK_W:
                    up = true;
                    break;
                case KeyEvent.VK_S:
                    down = true;
                    break;
                case KeyEvent.VK_D:
                    right = true;
                    break;
                default:
                    break;
            }
        }
    }

    //松开键改变方向值
    public void minusDirection(KeyEvent event){
        if(live) {
            switch (event.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    left = false;
                    break;
                case KeyEvent.VK_UP:
                    up = false;
                    break;
                case KeyEvent.VK_DOWN:
                    down = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    right = false;
                    break;
                case KeyEvent.VK_A:
                    left = false;
                    break;
                case KeyEvent.VK_W:
                    up = false;
                    break;
                case KeyEvent.VK_S:
                    down = false;
                    break;
                case KeyEvent.VK_D:
                    right = false;
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void drawMySelf(Graphics g) {
        // 创建 Graphics 的副本, 需要改变 Graphics 的参数,
        // 这里必须使用副本, 避免影响到 Graphics 原有的设置
        Graphics2D graphics = (Graphics2D) g.create();

        //live 为true飞机才存在，false飞机被销毁
        if(live) {
            super.drawMySelf(graphics);
            if (x > Constants.bgWidth - Constants.planeWidth) {
                x = 0;
            } else if (x < -Constants.planeWidth) {
                x = Constants.bgWidth;
            } else {
                if (left) x -= speed;
                if (right) x += speed;
            }
            if (y < 0) {
                y = Constants.bgHeight - Constants.planeHeight;
            } else if (y > Constants.bgHeight) {
                y = 0;
            } else {
                if (up) y -= speed;
                if (down) y += speed;
            }
        }

        //销毁创建对副本
        graphics.dispose();
    }

    public Plane(Image image, double x, double y) {
        super(image, x, y);
    }

    public Plane(Image image, double x, double y, int speed, int width, int height) {
        super(image, x, y, speed, width, height);
        this.speed = speed;
    }
}
