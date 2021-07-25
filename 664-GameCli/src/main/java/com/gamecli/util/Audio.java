package main.java.com.gamecli.util;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ProjectName: 23designpattern_java
 * @Package: main.java.com.test.util
 * @ClassName: Audio
 * @Author: chenyang
 * @Description: 声效枚举
 * @Date: 2021/7/23 11:23 下午
 * @Version: 1.0
 */
public enum Audio {
    DestroyBoom("boom.wav"),
    Firing("throwLighting.wav");

    private String name;
    Audio(String name) {
        this.name = name;
    }

    public void play(){
        AudioStream audioStream = null;
        try {
            InputStream inputStream = Audio.class.getClassLoader().getResourceAsStream("audio/"+name);
            audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
