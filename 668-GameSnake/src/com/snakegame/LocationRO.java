package com.snakegame;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.snakegame
 * @ClassName: LocationRO
 * @Author: chenyang
 * @Description: 定位类
 * @Date: 2021/7/18 11:58 下午
 * @Version: 1.0
 */
public class LocationRO{
    private int x;
    private int y;
    LocationRO(int x,int y){
        this.x=x;
        this.y=y;
    }
    int getX(){
        return x;
    }
    int getY(){
        return y;
    }
    //同向或反向
    public boolean equalOrRev(LocationRO e){
        return ((e.getX()==getX())&&(e.getY()==getY()))
                ||((e.getX()==getX())&&(e.getY()==-1*getY()))
                ||((e.getX()==-1*getX())&&(e.getY()==getY()));
    }
    //同向
    public boolean equals(LocationRO e){
        return(e.getX()==getX())&&(e.getY()==getY());
    }
    //反向
    public boolean reverse(LocationRO e){
        return ((e.getX()==getX())&&(e.getY()==-1*getY()))
                ||((e.getX()==-1*getX())&&(e.getY()==getY()));
    }
}