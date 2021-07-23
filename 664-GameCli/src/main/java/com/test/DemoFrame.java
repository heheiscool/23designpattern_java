package main.java.com.test;

import main.java.com.test.config.Constants;
import main.java.com.test.config.Keys;
import main.java.com.test.gameelements.Face;
import main.java.com.test.gameelements.FootBall;
import main.java.com.test.gameelements.Plane;
import main.java.com.test.gameelements.base.GameObject;
import main.java.com.test.gameelements.base.IDraw;
import main.java.com.test.util.GameUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.test
 * @ClassName: DemoFrame
 * @Author: chenyang
 * @Description: 主窗体入口
 * @Date: 2021/7/19 10:12 下午
 * @Version: 1.0
 */
public class DemoFrame extends JFrame {

    private static int count = 0;

    public DemoFrame() {
        this.setTitle("这个是一个游戏的框架Demo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //窗体退出方式
        this.setSize(Constants.bgWidth,Constants.bgHeight+20);

        this.launchFrame();
    }

    //游戏初开始启动
    private void launchFrame(){

        ArrayList<IDraw> arrayList = new ArrayList<>();

        //游戏元素
        FootBall footBall = new FootBall();
//        Face face = new Face();
        Plane plane = new Plane();

        arrayList.add(footBall);
//        arrayList.add(face);
        arrayList.add(plane);
        Face[] bullet = new Face[100];
        for(int i=0;i<100;i++) {
            bullet[i] = new Face();
            bullet[i].setY(1000);
            bullet[i].setStatus(1);
            arrayList.add(bullet[i]);
        }
        DemoPanel demoPanel = new DemoPanel(arrayList.toArray(new IDraw[arrayList.size()]));  //对象注入到面板


        //面板添加到窗体内
        this.add(demoPanel);
        this.setVisible(true);

        GameUtil.task(5,()->{
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(footBall.getX()>Constants.bgWidth){
                footBall.setX(0);
            }else {
                footBall.setX(footBall.getX() + 10);
            }

            for(int i=0;i<100;i++){
                //发射子弹的条件
                if (bullet[i].getY() < 1000 && bullet[i].getStatus()== 2 && bullet[i].getY() > -50) {
                    bullet[i].setY(bullet[i].getY() - 10);
                    System.out.println("第 "+i+" 颗子弹信息===>：("+ bullet[i].getRect().toString()+")======");
                    System.out.println("足球信息--->：("+ footBall.getRect().toString()+")------");
                    System.out.println(bullet[i].intersects(footBall));
                    Constants.TIMER_STOP_ON_OFF = bullet[i].intersects(footBall);
                    if(Constants.TIMER_STOP_ON_OFF){ //必须跳出这个循环不然变量值还是会发生改变
                        break;
                    }
                }
            }

            demoPanel.repaint();
        });

        //玩家键盘监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Keys.add(e.getKeyCode());
                if(e.getKeyCode() == KeyEvent.VK_A){
                    if(plane.getX()<0)
                        plane.setX(Constants.bgWidth-plane.getWidth());
                    else
                        plane.setX(plane.getX()-5);

                }else if(e.getKeyCode() == KeyEvent.VK_D){
                    if(plane.getX()>Constants.bgWidth)
                        plane.setX(0);
                    else
                        plane.setX(plane.getX()+5);
                }else if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    if(count<100) {
                        bullet[count].setStatus(2);
                        bullet[count].setX((Constants.bgWidth+plane.getWidth()-bullet[count].getWidth())/2);
                        bullet[count].setY(plane.getY());
                        count = count+1;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                Keys.remove(e.getKeyCode());
            }
        });

//        boolean breakWhile = false;
//        //刷新显示窗体内容
//        while (true) {
//
//            try {
//                Thread.sleep(40);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if(footBall.getX()>Constants.bgWidth){
//                footBall.setX(0);
//            }else {
//                footBall.setX(footBall.getX() + 10);
//            }
//
//            for(int i=0;i<100;i++){
//                //发射子弹的条件
//                if (bullet[i].getY() < 1000 && bullet[i].getStatus()== 2 && bullet[i].getY() > -50) {
//                    bullet[i].setY(bullet[i].getY() - 10);
//                    System.out.println("第 "+i+" 颗子弹信息===>：("+ bullet[i].getRect().toString()+")======");
//                    System.out.println("足球信息--->：("+ footBall.getRect().toString()+")------");
//                    System.out.println(bullet[i].intersects(footBall));
//                    if (breakWhile = bullet[i].intersects(footBall)) {
//                        break;
//                    }
//                }
//            }
//            if(breakWhile) break;
//            demoPanel.repaint();
//        }

    }

    public static void main(String[] args) {
        new DemoFrame();
    }





}
