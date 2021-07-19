package game.cli.gameelements;

import javax.management.timer.TimerMBean;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @ProjectName: 23designpattern_java
 * @Package: game.tetris
 * @ClassName: GameObject
 * @Author: chenyang
 * @Description: 通用对象
 * @Date: 2021/7/16 1:01 下午
 * @Version: 1.0
 */
public class GameObject {

    Image image;    //该物体对应的图片对象
    public double x,y;     //物体的坐标
    public int speed;      //物体速度
    public int width,height; //物理所在的矩形区域宽度和高度



    /*
     *   在游戏面板上绘制本对象
     */
    public void drawMySelf(Graphics g){
        // 创建 Graphics 的副本, 需要改变 Graphics 的参数,
        // 这里必须使用副本, 避免影响到 Graphics 原有的设置
        Graphics2D graphics = (Graphics2D) g.create();
        if(width>0 && height>0)
            graphics.drawImage(image,(int)x,(int)y,width,height,null);
        else
            graphics.drawImage(image,(int)x,(int)y,null);
        //销毁创建对副本
        graphics.dispose();
    }


    public GameObject() {
    }

    public GameObject(Image image, double x, double y) {
        this.image = image;
        this.x = x;
        this.y = y;
        if(image!=null){
            this.width = image.getWidth(null);
            this.height = image.getHeight(null);
        }
    }

    public GameObject(Image image, double x, double y, int speed, int width, int height) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    /*
     * 返回物理矩形区域
     */
    public Rectangle getRect(){
        return new Rectangle((int)x,(int)y,width,height);
    }
}
