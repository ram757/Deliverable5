import static org.junit.Assert.*;

import org.junit.Test;


public class EscapeTheGameTest
{

    @Test
    public void testRunIntroduction()
    {
        EscapeTheGame game = new EscapeTheGame();
        assertEquals(0, game.runIntroduction("Name"));
    }

}
