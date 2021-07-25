package main.java.com.gamecli.util;

/**
 * @ProjectName: 23designpattern_java
 * @Package: main.java.com.gamecli.util
 * @ClassName: Direction
 * @Author: chenyang
 * @Description: 游戏元素方向
 * @Date: 2021/7/24 11:01 上午
 * @Version: 1.0
 */
public enum Direction {
    LEFT{
        //枚举值为LEFT时候改变默认值
        @Override
        public boolean left() {
            return true;
        }
    },
    RIGHT{
        @Override
        public boolean right() {
            return true;
        }
    },
    UP{
        @Override
        public boolean up() {
            return true;
        }
    },
    DOWN{
        @Override
        public boolean down() {
            return true;
        }
    };

    //默认值
    public boolean left(){
        return false;
    }

    //默认
    public boolean right(){
        return false;
    }

    //默认值
    public boolean up(){
        return false;
    }

    //默认
    public boolean down(){
        return false;
    }



}
