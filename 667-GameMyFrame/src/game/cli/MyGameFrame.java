package game.cli;

import game.cli.config.Constants;
import game.cli.gameelements.Explode;
import game.cli.gameelements.FontGame;
import game.cli.gameelements.Plane;
import game.cli.gameelements.Shell;
import game.cli.util.GameUtil;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;


/**
 * @ProjectName: 23designpattern_java
 * @Package: game.tetris
 * @ClassName: TetrisTest
 * @Author: chenyang
 * @Description: 测试
 * @Date: 2021/7/15 6:04 下午
 * @Version: 1.0
 */
public class MyGameFrame extends Frame{

    private static MyGameFrame myGameFrame = new MyGameFrame();

    boolean liveStart = false;   //游戏开始
    boolean paus = false;   //暂停
    //定义时间
    //游戏开始时间
    Date startTime = new Date();
    //游戏结束时间
    Date endTime;

    static int count,countPaus = 0;   //countPaus为暂停计数
    static int countBuffer = 0;
    Image bgImg = GameUtil.getImages("images/bg.jpeg");
    Image planeImg = GameUtil.getImages("images/plane.png");

    double planeX = (Constants.bgWidth - Constants.planeWidth)/2;
    double planeY = Constants.bgHeight - Constants.planeWidth;


//  飞机对象
    Plane plane = new Plane(planeImg,planeX,planeY,3,Constants.planeWidth,Constants.planeHeight);
    Explode bao = null;
//  炮弹对象
    ArrayList<Shell> shellArrayList = new ArrayList<>();


    public static void main(String[] args) {

        myGameFrame.launchFrame();
    }


    //每40ms重新绘制一次
    @Override
    public void paint(Graphics g) {
    //  v0.5版本
        g.drawImage(bgImg,0,0,Constants.bgWidth,Constants.bgHeight,null);
        if(liveStart && !paus) {
            //  画出飞机
            plane.drawMySelf(g);
            //  画出所有子弹
            for (int i = 0; i < shellArrayList.size(); i++) {
                Shell shell = shellArrayList.get(i);
                shell.drawMySelf(g);
                //将此时画出的炮弹矩形和飞机矩形进行矩形交集检测
                boolean peng = shell.getRect().intersects(plane.getRect());
                if (peng) {
                    //飞机不显示
                    plane.live = false;
                    if (bao == null) {
                        bao = new Explode(plane.x, plane.y);
                    }
                    //画出爆炸效果
                    bao.drawMySelf(g);

                }
            }
        }
        if(!liveStart && !paus) {
            System.out.println("+++++++++ 游戏没有启动，但是"+Thread.currentThread().getName()+"正在执行pain呢 ++++++++");
            FontGame fontGame = new FontGame();
            fontGame.drawFont(g,"游戏停止 请按空格键重新开始");
        }

        if(paus) {
            System.out.println("+++++++++ 游戏暂停 ++++++++");
            FontGame fontGame = new FontGame();
            fontGame.drawFont(g,"游戏暂停");
        }


    }

//  双缓冲技术
    private Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if(offScreenImage==null){
        //1、创建与画布一样的缓存区
            offScreenImage = this.createImage(Constants.bgWidth,Constants.bgHeight);
        }
        //2、在缓存区画图
        Graphics gOff = offScreenImage.getGraphics();
        //3、将缓存区绘制好的图绘制到画布上
        paint(gOff);
        //4、释放
        g.drawImage(offScreenImage,0,0,null);
        //System.out.println("调用缓存图,重绘窗口，次数"+(countBuffer++));
    }




    public void launchFrame(){
        setTitle("游戏框架");
        setVisible(true);
        setSize(Constants.bgWidth,Constants.bgHeight);
        setLocation(400,50);

        //初始化炮弹
        for(int i=0;i<30;i++){
            Shell shell = new Shell();
            shellArrayList.add(shell);
        }
        //监听窗体
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        //监听键盘
        addKeyListener(new KeyMonitor());

        liveStart = true;  //设置为true才能运行
        new Thread(new PainThread()).start();
    }


//  多开一个线程是否能提高速度？会不会造成线程数据不安全？
    class PainThread implements Runnable {
        public void run(){
            //游戏暂停
            while(paus){
                System.out.println("游戏暂停");
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("============"+Thread.currentThread().getName()+"启动========");

            while (liveStart) {
                repaint();
                try {
                    Thread.sleep(40 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

//  定义内部类可以更方便的调用外部类属性和方法
    class KeyMonitor extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //ESC停止
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                liveStart = false;
                //对屏幕释放
                repaint();
            }

            //F1暂停
            if(e.getKeyCode() == KeyEvent.VK_F1){
                if(countPaus%2 == 0){
                    paus = true;
                }
                if(countPaus%2 == 1) {
                    paus = false;
                }
                countPaus++;
            }

            //Space键重新开始
            //这里存在问题是会不断开启新的线程？？？？？
            if(e.getKeyCode() == KeyEvent.VK_SPACE){

//                MyGameFrame myGameFrame = new MyGameFrame();
                myGameFrame.launchFrame();
            }
            plane.minusDirection(e);
        }
    }



}
