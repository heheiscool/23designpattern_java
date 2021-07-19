package com.snakegame;

/**
 * @ProjectName: 23designpattern_java
 * @Package: com.snakegame
 * @ClassName: Location
 * @Author: chenyang
 * @Description:
 * @Date: 2021/7/18 11:59 下午
 * @Version: 1.0
 */

public class Location {
    private int x;
    private int y;
    Location(int x,int y){
        this.x=x;
        this.y=y;
    }
    int getX(){
        return x;
    }
    int getY(){
        return y;
    }
    void setX(int x){
        this.x=x;
    }
    void setY(int y){
        this.y=y;
    }
    //同向或反向
    public boolean equalOrRev(Location e){
        return ((e.getX()==getX())&&(e.getY()==getY()))
                ||((e.getX()==getX())&&(e.getY()==-1*getY()))
                ||((e.getX()==-1*getX())&&(e.getY()==getY()));
    }
    //同向
    public boolean equals(Location e){
        return(e.getX()==getX())&&(e.getY()==getY());
    }
    //反向
    public boolean reverse(Location e){
        return ((e.getX()==getX())&&(e.getY()==-1*getY()))
                ||((e.getX()==-1*getX())&&(e.getY()==getY()));
    }
}
