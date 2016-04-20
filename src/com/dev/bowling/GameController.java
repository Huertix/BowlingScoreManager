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

    }

    private void updateFrames(){
        
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
