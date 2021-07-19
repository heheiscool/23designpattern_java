package game.cli.gameelements;

import game.cli.config.Constants;
import sun.font.FontDesignMetrics;

import java.awt.*;

/**
 * @ProjectName: 23designpattern_java
 * @Package: game.cli.gameelements
 * @ClassName: Font
 * @Author: chenyang
 * @Description: 文字类
 * @Date: 2021/7/18 2:19 下午
 * @Version: 1.0
 */
public class FontGame extends GameObject {

    public int getWordWidth(Font font, String content) {
        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
        int width = 0;
        for (int i = 0; i < content.length(); i++) {
            width += metrics.charWidth(content.charAt(i));
        }
        return width;
    }

    public void drawFont(Graphics g,String content) {
        // 创建 Graphics 的副本, 需要改变 Graphics 的参数,
        // 这里必须使用副本, 避免影响到 Graphics 原有的设置
        Graphics2D graphics = (Graphics2D) g.create();

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color color = graphics.getColor();
        graphics.setColor(color.white);
        Font fontShow = new Font("Helvetica",Font.PLAIN,25);
        graphics.setFont(fontShow);

        width = getWordWidth(fontShow,content);

        graphics.drawString(content, (Constants.bgWidth-width)/2,Constants.bgHeight/2);
        System.out.println("文字显示");
        graphics.dispose();

    }
}
