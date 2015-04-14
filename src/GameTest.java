import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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

    @Test
    /*
     * Test that moving North in game successfully operates with 
     * proper input in that it will call the appropriate method
     */
    public void testGameMoveNorth()
    {
        when(mockHouse.moveNorth()).thenReturn(true);
        
        Game game = new Game(mockPlayer, mockHouse);
        String direction = "north";
        
        int expectedValue = 1;
        int returnValue = game.move(direction);
        
        Mockito.verify(mockHouse).moveNorth();
        assertTrue(expectedValue == returnValue);
    }
    
    @Test
    /*
     * Test that moving South in game successfully operates with 
     * proper input in that it will call the appropriate method
     */
    public void testGameMoveSouth()
    {
        when(mockHouse.moveSouth()).thenReturn(true);
        
        Game game = new Game(mockPlayer, mockHouse);
        String direction = "south";
        
        int expectedValue = 1;
        int returnValue = game.move(direction);
        
        Mockito.verify(mockHouse).moveSouth();
        assertTrue(expectedValue == returnValue);
    }
    
    @Test
    /*
     * Test that moving West in game successfully operates with 
     * proper input in that it will call the appropriate method
     */
    public void testGameMoveWest()
    {
        when(mockHouse.moveWest()).thenReturn(true);
        
        Game game = new Game(mockPlayer, mockHouse);
        String direction = "west";
        
        int expectedValue = 1;
        int returnValue = game.move(direction);
        
        Mockito.verify(mockHouse).moveWest();
        assertTrue(expectedValue == returnValue);
    }
    
    @Test
    /*
     * Test that moving East in game successfully operates with 
     * proper input in that it will call the appropriate method
     */
    public void testGameMoveEast()
    {
        when(mockHouse.moveEast()).thenReturn(true);
        
        Game game = new Game(mockPlayer, mockHouse);
        String direction = "east";
        
        int expectedValue = 1;
        int returnValue = game.move(direction);
        
        Mockito.verify(mockHouse).moveEast();
        assertTrue(expectedValue == returnValue);
    }
    
    @Test
    /*
     * Test that moving to wrong direction in game successfully operates with 
     * proper input in that it will fail to work and produce error code
     */
    public void testGameMoveNowhere()
    {
        Game game = new Game(mockPlayer, mockHouse);
        String direction = "nowhere";
        
        int expectedValue = -1;
        int returnValue = game.move(direction);
        
        assertTrue(expectedValue == returnValue);
    }
    
    @Test
    /*
     * Test that moving to wrong direction in game successfully operates with 
     * proper input in that it will fail to work and produce error code
     */
    public void testGameMoveEastFail()
    {
        when(mockHouse.moveEast()).thenReturn(false);
        
        Game game = new Game(mockPlayer, mockHouse);
        String direction = "east";
        
        int expectedValue = -1;
        int returnValue = game.move(direction);
        
        Mockito.verify(mockHouse).moveEast();
        assertTrue(expectedValue == returnValue);
    }
    
    
}
