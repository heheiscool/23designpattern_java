package main.java.com.test.gameelements.base;

import java.awt.*;

/**
 * @ProjectName: 23designpattern_java
 * @Package: main.java.com.test.gameelements
 * @ClassName: GameObject
 * @Author: chenyang
 * @Description: 游戏原始元素类
 * @Date: 2021/7/19 11:25 下午
 * @Version: 1.0
 */
public class GameObject implements IDraw{
    protected Image image;
    protected int x,y;
    protected int width,height;
    protected int speed;
    protected int status;



    public GameObject() {
    }

    public GameObject(int x, int y, int width, int height, Image image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public GameObject(int x, int y, int width, int height, Image image, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
        this.speed = speed;
    }



    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStatus() { return status; }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setStatus(int status) { this.status = status; }

    /*
     * 返回物理矩形区域
     */
    public Rectangle getRect(){
        return new Rectangle((int)x,(int)y,width,height);
    }

    /*
     *   在游戏面板上绘制本对象
     */
    @Override
    public void drawImage(Graphics g) {
        // 创建 Graphics 的副本, 需要改变 Graphics 的参数,
        // 这里必须使用副本, 避免影响到 Graphics 原有的设置
        Graphics2D graphics = (Graphics2D) g.create();

        //而图像的观察者observer 参数，传递了null值，也可以传 this 即该类为图像的观察者。
        // 当 observer 对象为非空时，原始图像更改时会通知观察者
        //g.drawImage(image,50,50,20,20,null);
        if(this.getWidth()>0 && this.getHeight()>0)
            graphics.drawImage(this.getImage(),this.getX(),this.getY(),this.getWidth(),this.getHeight(),null);
        else
            graphics.drawImage(this.getImage(),this.getX(),this.getY(),null);
        //销毁创建对副本
        graphics.dispose();
    }

    /*
     *   碰撞检测
     */
    public boolean intersects(GameObject object){
        return this.getRect().intersects(object.getRect());
    }


}
