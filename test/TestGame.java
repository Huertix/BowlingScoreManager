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
}
