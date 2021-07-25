package main.java.com.gamecli.gameelements.base;

import main.java.com.gamecli.util.Direction;

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
public class BaseGameObject implements IDraw{
    protected int x,y;//坐标
    protected int width,height;//图外部矩形宽高
    protected Image image;
    protected Image leftImage;//绘制图片 朝向为左
    protected Image RightImage;//绘制图片 朝向为右
    protected float xSpeed, ySpeed;//x轴与y轴的移动速度
    protected float degree; //旋转
    protected Direction direction;

    //一个备用的状态
    protected int status;



    public BaseGameObject() {
    }



    public BaseGameObject(int x, int y) {
        this.x = x;
        this.y = y;

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

    public Image getImage() {
        return image;
    }

    public Image getLeftImage() {
        return leftImage;
    }

    public Image getRightImage() {
        return RightImage;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public float getDegree() {
        return degree;
    }

    public int getStatus() {
        return status;
    }

    public Direction getDirection() { return direction; }

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

    public void setImage(Image image) {
        this.image = image;
    }

    public void setLeftImage(Image leftImage) {
        this.leftImage = leftImage;
    }

    public void setRightImage(Image rightImage) {
        RightImage = rightImage;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setDegree(float degree) {
        this.degree = degree;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setDirection(Direction direction) { this.direction = direction; }

    //**************************************************************************************


    //元素常规动作
    public void action(){
        xMove();
        yMove();
    }


    //元素左右移动
    public void xMove(){
        this.x += direction.right()? +xSpeed : -xSpeed;
    }
    //元素下移动
    public void yMove(){
        this.y -= direction.up()? +ySpeed : -ySpeed;
    }

    /*
     * 返回物理矩形区域
     */
    public Rectangle getRect(){
        return new Rectangle(this.x,this.y,this.width,this.height);
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
    public boolean intersects(BaseGameObject object){
        return this.getRect().intersects(object.getRect());
    }


}
