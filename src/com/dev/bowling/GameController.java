package com.dev.bowling;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private static final int TOTAL_FRAMES = 10;
    private static final int FIRST_THROW_STATE = 1;
    private static final int SECOND_THROW_STATE = 2;
    private int currentFrame;
    private int[] framesScore;
    private int state;
    private List<Frame> frameList;

    public GameController(){
        initGame();
    }

    private void initGame(){
        currentFrame = 1;
        frameList = new ArrayList<Frame>();
        state = FIRST_THROW_STATE;
    }

    public void newThrow(int pins){
        if(pins > 10){
            System.out.println("Number of pins wrong");
            return;
        }
        if(!gameIsOver()){
            switch (state){
                case FIRST_THROW_STATE:
                    Frame f = new Frame();
                    f.setThrow1(pins);
                    if(pins < 10)
                        state = SECOND_THROW_STATE;
                    else
                        currentFrame++;

                    frameList.add(f);
                    break;

            case SECOND_THROW_STATE:
                f = frameList.get(currentFrame - 1);
                if(f.getThrow1() + pins > 10){
                    System.out.println("Number of pins wrong");
                    return;
                }
                f.setThrow2(pins);
                state = FIRST_THROW_STATE;
                currentFrame++;
                updateFrames();
                updateScores();
                break;
            }
        }
    }

    private void updateFrames(){
        int index = currentFrame - 1;
        for( int i = 0; i < frameList.size(); i++ ) {
            Frame f = frameList.get(i);
            f.setScore(f.getThrow1() + f.getThrow2());
        }
    }

    private void updateScores(){

    }

    public int getScoreAtFrame(int frame){
        int index = frame -1;
        Frame f = frameList.get(index);
        return f.getScore();
    }

    public Frame getFrame(int frame){ return frameList.get(frame - 1); }

    public boolean gameIsOver(){
        return currentFrame > TOTAL_FRAMES;
    }
}
