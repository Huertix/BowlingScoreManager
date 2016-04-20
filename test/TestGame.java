import com.dev.bowling.GameController;
import junit.framework.TestCase;
import org.junit.Test;

public class TestGame extends TestCase {

    @Test
    public void testInit(){
        GameController gc = new GameController();
        assertFalse("Game is not over", gc.gameIsOver());
    }
}
