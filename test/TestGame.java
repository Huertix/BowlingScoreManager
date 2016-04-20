import com.dev.bowling.GameController;
import junit.framework.TestCase;
import org.junit.Test;

public class TestGame extends TestCase{


    @Test
    public void testInit() {
        GameController gc = new GameController();
        int[] balls = {3, 4, 2, 1, 3, 4, 5, 4, 2, 4, 3, 4, 3, 3, 1, 4, 0, 4, 3, 4};
        int[] scoreInFrame = {7, 3, 7, 9, 6, 7, 6, 5, 4, 7};
        int[] accumulativeScore = {7, 10, 17, 26, 32, 39, 45, 50, 54, 61};
        testGame(gc, balls, scoreInFrame, accumulativeScore);
    }

    @Test
    public void testWithStrikes(){
        GameController gc = new GameController();
        int[] balls = {5, 2, 8, 1, 10, 3, 2, 10, 10, 1, 6, 10, 2, 6, 4, 5};
        int[] scoreInFrame = {7, 9, 15, 5, 21, 17, 7, 18, 8, 9};
        int[] accumulativeScore = {7, 16, 31, 36, 57, 74, 81, 99, 107, 116};
        testGame(gc, balls, scoreInFrame, accumulativeScore);
    }


    @Test
    public void testWithStrikesAndSpares(){
        GameController gc = new GameController();
        int[] balls = {5, 2, 8, 2, 10, 3, 2, 4, 6, 5, 5, 1, 6, 10, 2, 6, 4, 3};
        int[] scoreInFrame = {7, 20, 15, 5, 15, 11, 7, 18, 8, 7};
        int[] accumulativeScore = {7, 27, 42, 47, 62, 73, 80, 98, 106, 113};
        testGame(gc, balls, scoreInFrame, accumulativeScore);
    }

    @Test
    public void testLastFrameStrike(){
        GameController gc = new GameController();
        int[] balls = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 10, 1};
        int[] scoreInFrame = {2, 2, 2, 2, 2, 2, 2, 2, 2, 21};
        int[] accumulativeScore = {2, 4, 6, 8, 10, 12, 14, 16, 18, 39};
        testGame(gc, balls, scoreInFrame, accumulativeScore);
    }

    @Test
    public void testLastFrameSpare(){
        GameController gc = new GameController();
        int[] balls = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 5, 2};
        int[] scoreInFrame = {2, 2, 2, 2, 2, 2, 2, 2, 2, 12};
        int[] accumulativeScore = {2, 4, 6, 8, 10, 12, 14, 16, 18, 30};
        testGame(gc, balls, scoreInFrame, accumulativeScore);
    }

    @Test
    public void testLastFrameStrikesAndSpares(){
        GameController gc = new GameController();
        int[] balls = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 5, 10};
        int[] scoreInFrame = {2, 2, 2, 2, 2, 2, 2, 2, 2, 20};
        int[] accumulativeScore = {2, 4, 6, 8, 10, 12, 14, 16, 18, 38};
        testGame(gc, balls, scoreInFrame, accumulativeScore);
    }


    // Helper method.
    private void testGame(GameController gc, int[] balls, int[] scoreInFrame, int[] accumulativeScore){

        for( int i = 0; i < balls.length; i++){
            gc.newThrow(balls[i]);
        }
        for( int i = 0; i < scoreInFrame.length; i++){
            assertEquals("Score in Frame " + (i + 1 ) +" != "+ scoreInFrame[i],
                    scoreInFrame[i], gc.getFrame(i + 1).getScore());
        }
        for( int i = 0; i < accumulativeScore.length; i++){
            assertEquals("Total score in Frame " + (i + 1 ) +" != "+ accumulativeScore[i],
                    accumulativeScore [i], gc.getScoreAtFrame(i + 1));
        }
    }
}