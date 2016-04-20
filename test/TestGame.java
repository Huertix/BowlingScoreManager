import com.dev.bowling.GameController;
import junit.framework.TestCase;
import org.junit.Test;

public class TestGame extends TestCase {

    @Test
    public void testInit(){
        GameController gc = new GameController();
        gc.newThrow(3);
        gc.newThrow(4);
        assertEquals("Score Frame1 = 7", 7, gc.getFrame(1).getScore());
        assertFalse("Game is not over", gc.gameIsOver());
        gc.newThrow(2);
        gc.newThrow(1);
        assertEquals("Score Frame2 = 3", 3, gc.getFrame(2).getScore());
        assertEquals("TotalScore in Frame2 = 10", 10, gc.getScoreAtFrame(2));
        gc.newThrow(3);
        gc.newThrow(4);
        assertEquals("Score Frame3 = 7", 7, gc.getFrame(3).getScore());
        assertEquals("TotalScore in Frame3 = 17", 17, gc.getScoreAtFrame(3));
        gc.newThrow(5);
        gc.newThrow(4);
        assertEquals("Score Frame4 = 9", 9, gc.getFrame(4).getScore());
        assertFalse("Game is not over", gc.gameIsOver());
        gc.newThrow(2);
        gc.newThrow(4);
        assertEquals("Score Frame5 = 6", 6, gc.getFrame(5).getScore());
        gc.newThrow(3);
        gc.newThrow(4);
        assertEquals("Score Frame6 = 7", 7, gc.getFrame(6).getScore());
        assertFalse("Game is not over", gc.gameIsOver());
        gc.newThrow(3);
        gc.newThrow(3);
        assertEquals("Score Frame7 = 6", 6, gc.getFrame(7).getScore());
        assertEquals("TotalScore in Frame6 = 39", 39, gc.getScoreAtFrame(6));
        gc.newThrow(1);
        gc.newThrow(4);
        assertEquals("Score Frame8 = 5", 5, gc.getFrame(8).getScore());
        gc.newThrow(0);
        gc.newThrow(4);
        assertEquals("Score Frame9 = 4", 4, gc.getFrame(9).getScore());
        assertFalse("Game is not over", gc.gameIsOver());
        gc.newThrow(3);
        gc.newThrow(4);
        assertEquals("TotalScore in Frame10 = 61", 61, gc.getScoreAtFrame(10));
        assertTrue("Game is over", gc.gameIsOver());
    }

    @Test
    public void testWithStrikes(){
        GameController gc = new GameController();
        gc.newThrow(5);
        gc.newThrow(2);
        assertEquals("Score Frame1 = 7", 7, gc.getScoreAtFrame(1));
        gc.newThrow(8);
        gc.newThrow(1);
        assertEquals("Score Frame1 = 7", 7, gc.getScoreAtFrame(1));
        assertEquals("Score Frame2 = 16", 16, gc.getScoreAtFrame(2));
        gc.newThrow(10);
        assertEquals("Score Frame1 = 7", 7, gc.getScoreAtFrame(1));
        assertEquals("Score Frame2 = 16", 16, gc.getScoreAtFrame(2));
        gc.newThrow(3);
        gc.newThrow(2);
        assertEquals("Score Frame1 = 7", 7, gc.getScoreAtFrame(1));
        assertEquals("Score Frame2 = 16", 16, gc.getScoreAtFrame(2));
        assertEquals("Score Frame3 = 31", 31, gc.getScoreAtFrame(3));
        assertEquals("Score Frame4 = 36", 36, gc.getScoreAtFrame(4));
        gc.newThrow(10);
        assertEquals("Score Frame5 = 0", 0, gc.getScoreAtFrame(5));
        gc.newThrow(10);
        assertEquals("Score Frame6 = 0", 0, gc.getScoreAtFrame(6));
        gc.newThrow(1);
        gc.newThrow(6);
        assertEquals("Score Frame5 = 57", 57, gc.getScoreAtFrame(5));
        assertEquals("Score Frame6 = 74", 74, gc.getScoreAtFrame(6));
        assertEquals("Score Frame7 = 81", 81, gc.getScoreAtFrame(7));
        gc.newThrow(10);
        assertEquals("Score Frame8 = 0", 0, gc.getScoreAtFrame(8));
        gc.newThrow(2);
        gc.newThrow(6);
        assertEquals("Score Frame8 = 99", 99, gc.getScoreAtFrame(8));
        assertEquals("Score Frame9 = 107", 107, gc.getScoreAtFrame(9));
        gc.newThrow(4);
        gc.newThrow(5);
        assertEquals("Score Frame10 = 116", 116, gc.getScoreAtFrame(10));
        assertTrue("Game is over", gc.gameIsOver());
    }

    @Test
    public void testWithStrikesAndSpares(){
        GameController gc = new GameController();
        gc.newThrow(5);
        gc.newThrow(2);
        assertEquals("Score Frame1= 7", 7, gc.getScoreAtFrame(1));
        gc.newThrow(8);
        gc.newThrow(2);
        assertEquals("Score Frame1 = 7", 7, gc.getScoreAtFrame(1));
        gc.newThrow(10);
        assertEquals("Score Frame1 = 7", 7, gc.getScoreAtFrame(1));
        gc.newThrow(3);
        gc.newThrow(2);
        assertEquals("Score Frame1 = 7", 7, gc.getScoreAtFrame(1));
        assertEquals("Score Frame2 = 27", 27, gc.getScoreAtFrame(2));
        assertEquals("Score Frame3 = 42", 42, gc.getScoreAtFrame(3));
        assertEquals("Score Frame4 = 47", 47, gc.getScoreAtFrame(4));
        gc.newThrow(4);
        gc.newThrow(6);
        gc.newThrow(5);
        gc.newThrow(5);
        gc.newThrow(1);
        gc.newThrow(6);
        assertEquals("Score Frame5 = 62", 62, gc.getScoreAtFrame(5));
        assertEquals("Score Frame6 = 73",73, gc.getScoreAtFrame(6));
        assertEquals("Score Frame7 = 80", 80, gc.getScoreAtFrame(7));
        gc.newThrow(10);
        assertEquals("Score Frame8 = 0", 0, gc.getScoreAtFrame(8));
        gc.newThrow(2);
        gc.newThrow(6);
        assertEquals("Score Frame8 = 98", 98, gc.getScoreAtFrame(8));
        assertEquals("Score Frame9 = 106", 106, gc.getScoreAtFrame(9));
        gc.newThrow(4);
        gc.newThrow(3);
        assertEquals("Score Frame10 = 113", 113, gc.getScoreAtFrame(10));
        assertTrue("Game is over", gc.gameIsOver());
    }
}
