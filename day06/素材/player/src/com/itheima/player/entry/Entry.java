package com.itheima.player.entry;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Entry {

    public static void main(String[] args) throws Exception {

        // 补全代码


    }

    // 播放mp3音频文件的方法，方法参数需要一个本地音频文件的路径：D:/audio/a.mp3
    public static void play(String audioPath) throws Exception {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(audioPath)) ;
        Player player = new Player(bis) ;
        player.play();
    }

}
