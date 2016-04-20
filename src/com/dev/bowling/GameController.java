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
    private int lastIndexUpdated;

    public GameController(){
        initGame();
    }

    private void initGame(){
        currentFrame = 1;
        frameList = new ArrayList<Frame>();
        framesScore = new int[TOTAL_FRAMES];
        state = FIRST_THROW_STATE;
        lastIndexUpdated = 0;
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

    // Update scores in each frame
    private void updateFrames(){
        int index = currentFrame - 1;
        for( int i = 0; i < frameList.size(); i++ ) {
            Frame f = frameList.get(i);
            f.setScore(f.getThrow1() + f.getThrow2());
        }
    }

    // update accumulative score
    private void updateScores(){
        if(lastIndexUpdated > 0){
            for ( int i = lastIndexUpdated; i < frameList.size(); i++){
                framesScore[i] = framesScore[lastIndexUpdated - 1] + frameList.get(i).getScore();
                lastIndexUpdated++;
            }

        } else{
            framesScore[lastIndexUpdated] = frameList.get(lastIndexUpdated).getScore();
            lastIndexUpdated++;
        }
    }

    public int getScoreAtFrame(int frame){ return framesScore[frame -1]; }

    public Frame getFrame(int frame){ return frameList.get(frame - 1); }

    public boolean gameIsOver(){
        return currentFrame > TOTAL_FRAMES;
    }
}
