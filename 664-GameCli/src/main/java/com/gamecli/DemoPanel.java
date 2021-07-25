package main.java.com.gamecli;

import main.java.com.gamecli.config.Constants;
import main.java.com.gamecli.gameelements.base.IDraw;
import main.java.com.gamecli.util.GameUtil;

import javax.swing.*;
import java.awt.*;


/**
 * @ProjectName: 23designpattern_java
 * @Package: com.test
 * @ClassName: DemoPanel
 * @Author: chenyang
 * @Description: 装载图片的面板
 * @Date: 2021/7/19 10:11 下午
 * @Version: 1.0
 */
public class DemoPanel extends JPanel{
    private IDraw[] draws;
    //缓冲
    private Image offScreenImage = null;
    //背景图
    private Image backgroundImage = GameUtil.getImages("images/bg_dark.jpg");

    public DemoPanel() {
    }

    public DemoPanel(IDraw... draws ) {
        this.draws = draws;
    }

    /**
     * 绘制缓冲
     */
    private void drawBufferedImage() {
        offScreenImage = createImage(this.getWidth(),this.getHeight());
        Graphics g = offScreenImage.getGraphics();
        //绘制背景
        g.drawImage(backgroundImage,0,0, Constants.bgWidth,Constants.bgHeight,null);
        //绘制其他各类元素
        for(IDraw draw:draws){
            draw.drawImage(g);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //在paint方法中我们实例化了一个ImageIcon对象，它的参数为图片文件在src目录下的完整路径（包含文件格式后缀）
        drawBufferedImage();
        //绘制缓存
        g.drawImage(offScreenImage,0,0,null);
    }
}
