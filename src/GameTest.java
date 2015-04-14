import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class GameTest
{
    @Mock
    Player mockPlayer = Mockito.mock(Player.class);
    House mockHouse = Mockito.mock(House.class);
    
    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(mockPlayer);
        MockitoAnnotations.initMocks(mockHouse);
    }
    
    @Test
    /*
     * Test that Game constructor works properly
     */
    public void testGameConstructor()
    {
        Game game = new Game(mockPlayer, mockHouse);
        
        assertNotNull(game);
    }

}
