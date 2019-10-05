package com.example.basketballscoresapp;

public class Team {

    private int mScore = 0;
    private String mName;
    private int mFouls = 0;

    public Team() {
    }

    public Team(String name) {
        mName = name;
    }

    public int getScore() {
        return mScore;
    }

    public void setScore(int score) {
        mScore = score;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getFouls() {
        return mFouls;
    }

    public void setFouls(int fouls) {
        mFouls = fouls;
    }

    public void scorePoints(int points){
        mScore = mScore + points;
    }

    public void commitFoul(){
        mFouls = mFouls + 1;
    }
}
