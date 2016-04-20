package com.dev.bowling;


public class Frame {
    private Integer throw1;
    private Integer throw2;
    private int score;

    public Frame(){
        score = 0;
    }


    public Integer getThrow1(){
        return throw1;
    }

    public void setThrow1(int throw1){
        this.throw1 = throw1;
    }

    public Integer getThrow2(){
        return throw2;
    }

    public void setThrow2(int throw2){
        this.throw2 = throw2;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }
}
