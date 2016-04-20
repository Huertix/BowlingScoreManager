package com.dev.bowling;


public class Frame {
    private Integer throw1;
    private Integer throw2;
    private Integer extraThrow;
    private int score;
    private boolean isScorePending;
    private boolean isStrike;
    private boolean isSpare;

    public Frame(){
        score = 0;
        isScorePending = true;
        extraThrow = 0;
    }

    public Integer getThrow1(){ return throw1; }

    public void setThrow1(int throw1){ this.throw1 = throw1; }

    public Integer getThrow2(){ return throw2; }

    public void setThrow2(int throw2){ this.throw2 = throw2; }

    public Integer getExtraThrow() { return extraThrow; }

    public void setExtraThrow(int extraThrow) { this.extraThrow = extraThrow; }

    public boolean isScorePending() { return isScorePending; }

    public boolean isStrike() { return isStrike; }

    public void setStrike(boolean strike) { this.isStrike = strike; }

    public boolean isSpare() { return isSpare; }

    public void setSpare(boolean spare) { this.isSpare = spare; }

    public int getScore(){ return score; }

    public void setScore(int score){
        this.score = score;
        this.isStrike = false;
        this.isSpare = false;
        this.isScorePending = false;
    }
}