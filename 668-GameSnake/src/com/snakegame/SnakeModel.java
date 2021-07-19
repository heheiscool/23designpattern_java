package com.snakegame;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.snakegame
 * @ClassName: SnakeModel
 * @Author: chenyang
 * @Description:
 * @Date: 2021/7/19 12:00 上午
 * @Version: 1.0
 */
import java.util.*;
import javax.swing.JOptionPane;
public class SnakeModel{
    private int rows,cols;//行列数
    private Location snakeHead,runingDiriction;	//运行方向
    private LocationRO[][] locRO;					//LocationRO类数组
    private LinkedList snake,playBlocks;			//蛇及其他区域块
    private LocationRO snakeFood;		//目标食物
    private int gameScore=0;   			//分数
    private boolean AddScore=false;		//加分
    //获得蛇头
    public LocationRO getSnakeHead(){
        return (LocationRO)(snake.getLast());
    }
    //蛇尾
    public LocationRO getSnakeTail(){
        return (LocationRO)(snake.getFirst());
    }
    //运行路线
    public Location getRuningDiriction(){
        return runingDiriction;
    }
    //获得蛇实体区域
    public LinkedList getSnake(){
        return snake;
    }
    //其他区域
    public LinkedList getOthers(){
        return playBlocks;
    }
    //获得总分
    public int getScore(){
        return gameScore;
    }
    //获得增加分数
    public boolean getAddScore(){
        return AddScore;
    }
    //设置蛇头方向
    private void setSnakeHead(Location snakeHead){
        this.snakeHead=snakeHead;
    }
    //获得目标食物
    public LocationRO getSnakeFood(){
        return snakeFood;
    }
    //随机设置目标食物
    private void setSnakeFood(){
        snakeFood=(LocationRO)(playBlocks.get((int)(Math.random()*playBlocks.size())));
    }
    //移动
    private void moveTo(Object a,LinkedList fromlist,LinkedList tolist){
        fromlist.remove(a);
        tolist.add(a);
    }
    //初始设置
    public void init(){
        playBlocks.clear();
        snake.clear();
        gameScore=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                playBlocks.add(locRO[i][j]);
            }
        }

        //初始化蛇的形状
        for(int i=4;i<7;i++){
            moveTo(locRO[4][i],playBlocks,snake);
        }
        //蛇头位置
        snakeHead=new Location(4,6);

        //设置目标食物
        snakeFood=new LocationRO(0,0);
        setSnakeFood();
        //初始化运动方向
        runingDiriction=new Location(0,1);

    }
    //构建器
    public SnakeModel(int rows1,int cols1){
        rows=rows1;
        cols=cols1;
        locRO=new LocationRO[rows][cols];
        snake=new LinkedList();
        playBlocks=new LinkedList();

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                locRO[i][j]=new LocationRO(i,j);
            }
        }
        init();
    }
    /**定义布尔型move方法，如果运行成功则返回true，否则返回false
     *参数direction是Location类型，
     *direction 的值:(-1，0)表示向上；(1，0)表示向下；
     *(0，-1)表示向左；(0，1)表示向右
     **/
    public boolean move(Location direction){
        //判断设定的方向跟运行方向是不是相反
        if (direction.reverse(runingDiriction)){
            snakeHead.setX(snakeHead.getX()+runingDiriction.getX());
            snakeHead.setY(snakeHead.getY()+runingDiriction.getY());
        }else{
            snakeHead.setX(snakeHead.getX()+direction.getX());
            snakeHead.setY(snakeHead.getY()+direction.getY());
        }
        //如果蛇吃到了目标食物
        try{
            if ((snakeHead.getX()==snakeFood.getX()) &&(snakeHead.getY()==snakeFood.getY()))
            {
                moveTo(locRO[snakeHead.getX()][snakeHead.getY()],playBlocks,snake);
                setSnakeFood();
                gameScore+=10;
                AddScore=true;
            }else{
                AddScore=false;
                //是否出界
                if((snakeHead.getX()<rows)&&(snakeHead.getY()<cols)&&(snakeHead.getX()>=0&&(snakeHead.getY()>=0))){
                    //如果不出界，判断是否与自身相交
                    if(snake.contains(locRO[snakeHead.getX()][snakeHead.getY()])){
                        //如果相交，结束游戏
                        JOptionPane.showMessageDialog(null, "Game Over!", "游戏结束", JOptionPane.INFORMATION_MESSAGE);
                        return false;
                    }else{
                        //如果不相交，就把snakeHead加到snake里面，并且把尾巴移出
                        moveTo(locRO[snakeHead.getX()][snakeHead.getY()],playBlocks,snake);
                        moveTo(snake.getFirst(),snake,playBlocks);
                    }
                }else{
                    //出界，游戏结束
                    JOptionPane.showMessageDialog(null, "Game Over!", "游戏结束", JOptionPane.INFORMATION_MESSAGE);
                    return false;
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
    //设置运行方向
		if (!(direction.reverse(runingDiriction) ||direction.equals(runingDiriction))){
            runingDiriction.setX(direction.getX());
            runingDiriction.setY(direction.getY());
        }
		return true;
    }
}