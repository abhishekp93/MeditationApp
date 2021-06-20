package com.practical.meditationapp.model;

public class AllPracticesModel {

    String musicName;
    String musicTime;
    int bg;
    int like;

    public AllPracticesModel(String musicName, String musicTime, int bg, int like) {
        this.musicName = musicName;
        this.musicTime = musicTime;
        this.bg = bg;
        this.like = like;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicTime() {
        return musicTime;
    }

    public void setMusicTime(String musicTime) {
        this.musicTime = musicTime;
    }

    public int getBg() {
        return bg;
    }

    public void setBg(int bg) {
        this.bg = bg;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
