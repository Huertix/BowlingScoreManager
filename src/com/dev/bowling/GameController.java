package com.dev.bowling;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private static final int TOTAL_FRAMES = 10;
    private static final int FIRST_THROW_STATE = 1;
    private static final int SECOND_THROW_STATE = 2;
    private static final int EXTRA_THROW_STATE = 3;
    private boolean isFinalFrame;
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
                    else{
                        if(isFinalFrame)
                            state = SECOND_THROW_STATE;
                        else {
                            f.setStrike(true);
                            currentFrame++;
                        }
                    }
                    frameList.add(f);
                    break;

                case SECOND_THROW_STATE:
                    f = frameList.get(currentFrame - 1);
                    if(f.getThrow1() + pins > 10 && !isFinalFrame){
                        System.out.println("Number of pins wrong");
                        return;
                    }
                    f.setThrow2(pins);
                    if (f.getThrow1() + pins >= 10){
                        if(isFinalFrame)
                            state = EXTRA_THROW_STATE;
                        else{
                            f.setSpare(true);
                            state = FIRST_THROW_STATE;
                            currentFrame++;
                        }
                    } else{
                        state = FIRST_THROW_STATE;
                        currentFrame++;
                        updateFrames();
                        updateScores();
                    }
                    break;

                case EXTRA_THROW_STATE:
                    f = frameList.get(currentFrame - 1);
                    f.setExtraThrow(pins);
                    currentFrame++;
                    updateFrames();
                    updateScores();
                    break;
            }
            if(currentFrame > 9)
                isFinalFrame = true;
        }
    }

    // Update scores in each frame
    private void updateFrames(){
        int index = currentFrame - 1;
        for( int i = 0; i < frameList.size(); i++ ){
            Frame f = frameList.get(i);
            if(f.isStrike()){
                // In case there are 2 strike in a row
                if(index - i > 2){
                    Frame f1 = frameList.get(i + 1);
                    Frame f2 = null;
                    // In case there is another strike ahead
                    if( f1.getThrow2() == null){
                        f2 = frameList.get(i + 2);
                        f.setScore(10 + f1.getThrow1() + f2.getThrow1()); // Eg. Throws {10, 10 , 1}
                    }
                } else if(index - i > 1){ // In case there is a strike
                    Frame f1 = frameList.get(i + 1);
                    f.setScore(10 + f1.getThrow1() + f1.getThrow2()); // Eg. Throws {10, 3 , 2}
                } else { // Just Strike in the currentPosition
                    f.setScore(10 + f.getThrow1() + f.getThrow2());
                }
            } else if(f.isSpare()){
                // In case there is another spare ahead
                if(index - i > 0){
                    Frame f1 = frameList.get(i + 1);
                    f.setScore(10 + f1.getThrow1()); // Eg. Throws {8, 2 , 10}
                } else { // Just spare in the currentPosition
                    f.setScore(10 + f.getThrow1());
                }
            } else{
                if( f.isScorePending() )
                    f.setScore(f.getThrow1() + f.getThrow2() + f.getExtraThrow());
            }
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