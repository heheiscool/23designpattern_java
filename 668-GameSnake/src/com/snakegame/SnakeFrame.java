package com.snakegame;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.snakegame
 * @ClassName: SnakeFrame
 * @Author: chenyang
 * @Description: 菜单框架
 * @Date: 2021/7/18 11:53 下午
 * @Version: 1.0
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class SnakeFrame extends JFrame implements ActionListener{
    final SnakePanel p=new SnakePanel(this);
    //菜单栏
    JMenuBar menubar=new JMenuBar();
    //文件菜单
    JMenu fileMenu=new JMenu("文件");
    JMenuItem newgameitem=new JMenuItem("开始");
    JMenuItem stopitem=new JMenuItem("暂停");
    JMenuItem runitem=new JMenuItem("继续");
    JMenuItem exititem=new JMenuItem("退出");
    //游戏设置菜单
    JMenu optionMenu=new JMenu("设置");
    //等级设置
    ButtonGroup groupDegree = new ButtonGroup();
    JRadioButtonMenuItem lowItem= new JRadioButtonMenuItem("初级");
    JRadioButtonMenuItem midItem= new JRadioButtonMenuItem("中级");
    JRadioButtonMenuItem highItem= new JRadioButtonMenuItem("高级");
    JMenu degreeMenu=new JMenu("等级");
    JMenu helpMenu=new JMenu("帮助");
    JMenuItem helpitem=new JMenuItem("操作指南");
    //网格设置菜单
    final JCheckBoxMenuItem showGridItem = new JCheckBoxMenuItem("显示网格");
    JLabel scorelabel;
    public JTextField scoreField;
    //游戏速度
    private long speed=200;
    //操作帮助信息
    private String helpstr = "游戏说明：\n1 ：方向键控制蛇移动的方向."+
            "\n2 ：单击菜单'文件->开始'开始游戏."+
            "\n3 ：单击菜单'文件->暂停'或者单击键盘空格键暂停游戏."+
            "\n4 ：单击菜单'文件->继续'继续游戏."+
            "\n5 ：单击菜单'设置->等级'可以设置难度等级."+
            "\n6 ：单击菜单'设置->显示网格'可以设置是否显示网格."+
            "\n7 ：红色为食物,吃一个得10分同时蛇身加长."+
            "\n8 ：蛇不可以出界或自身相交，否则结束游戏.";
    //构建器
    SnakeFrame()
    {
        setJMenuBar(menubar);
        fileMenu.add(newgameitem);
        fileMenu.add(stopitem);
        fileMenu.add(runitem);
        fileMenu.add(exititem);
        menubar.add(fileMenu);
        lowItem.setSelected(true);
        groupDegree.add(lowItem);
        groupDegree.add(midItem);
        groupDegree.add(highItem);
        degreeMenu.add(lowItem);
        degreeMenu.add(midItem);
        degreeMenu.add(highItem);
        optionMenu.add(degreeMenu);
        // 默认设置显示网格
        showGridItem.setSelected(true);
        optionMenu.add(showGridItem);
        menubar.add(optionMenu);
        helpMenu.add(helpitem);
        menubar.add(helpMenu);
        Container contentpane=getContentPane();
        contentpane.setLayout(new FlowLayout());
        contentpane.add(p);
        //得分成绩标签及文本框
        scorelabel=new JLabel("得   分: ");
        scoreField=new JTextField("0",15);
        scoreField.setEnabled(false);
        scoreField.setHorizontalAlignment(0);
        JPanel scorePanel=new JPanel();
        scorePanel.add(scorelabel);
        scorePanel.add(scoreField);
        contentpane.add(scorePanel);
        //添加监听器
        lowItem.addActionListener(this);
        midItem.addActionListener(this);
        highItem.addActionListener(this);
        newgameitem.addActionListener(this);
        stopitem.addActionListener(this);
        runitem.addActionListener(this);
        exititem.addActionListener(this);
        helpitem.addActionListener(this);
        showGridItem.addActionListener(this);
    }
    //实现接口方法
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==helpitem){
                JOptionPane.showConfirmDialog(p,helpstr,"操纵说明",
                        JOptionPane.PLAIN_MESSAGE);
            }
            else if(e.getSource()==exititem) System.exit(0);
            else if(e.getSource()==newgameitem) p.newGame(speed);
            else if(e.getSource()==stopitem) p.stopGame();
            else if(e.getSource()==runitem) p.returnGame();
            else if(e.getSource()==showGridItem){
                if(!showGridItem.isSelected()){
                    p.setBackground(Color.lightGray);
                }else{
                    p.setBackground(Color.darkGray);
                }
            }
            else if(e.getSource()==lowItem) speed=200;
            else if(e.getSource()==midItem) speed=100;
            else if(e.getSource()==highItem) speed=50;
        }catch(Exception ee){ee.printStackTrace();}
    }
}