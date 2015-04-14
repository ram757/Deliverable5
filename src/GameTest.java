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
    
    @Test
    /*
     * Test that peeking north returns the correct response and 
     * verify that it called the appropriate method
     */
    public void testGamePeekNorth()
    {
        String expectedString = "yay";
        when(mockHouse.peekNorth()).thenReturn(expectedString);
        
        Game game = new Game(mockPlayer, mockHouse);
        String direction = "north";

        String returnedString = game.peek(direction);
        
        Mockito.verify(mockHouse).peekNorth();
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    /*
     * Test that peeking south returns the correct response and 
     * verify that it called the appropriate method
     */
    public void testGamePeekSouth()
    {
        String expectedString = "yay";
        when(mockHouse.peekSouth()).thenReturn(expectedString);
        
        Game game = new Game(mockPlayer, mockHouse);
        String direction = "south";

        String returnedString = game.peek(direction);
        
        Mockito.verify(mockHouse).peekSouth();
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    /*
     * Test that peeking north returns the correct response and 
     * verify that it called the appropriate method
     */
    public void testGamePeekEast()
    {
        String expectedString = "yay";
        when(mockHouse.peekEast()).thenReturn(expectedString);
        
        Game game = new Game(mockPlayer, mockHouse);
        String direction = "east";

        String returnedString = game.peek(direction);
        
        Mockito.verify(mockHouse).peekEast();
        assertEquals(expectedString, returnedString);
    }
    
    
    @Test
    /*
     * Test that peeking west returns the correct response and 
     * verify that it called the appropriate method
     */
    public void testGamePeekWest()
    {
        String expectedString = "yay";
        when(mockHouse.peekWest()).thenReturn(expectedString);
        
        Game game = new Game(mockPlayer, mockHouse);
        String direction = "west";

        String returnedString = game.peek(direction);
        
        Mockito.verify(mockHouse).peekWest();
        assertEquals(expectedString, returnedString);
    }
    
    
    @Test
    /*
     * Test that peeking incorrectly returns the correct response
     */
    public void testGamePeekNowhere()
    {
        String expectedStringContent = "You see a wall that is disturbingly";
        
        Game game = new Game(mockPlayer, mockHouse);
        String direction = "nowhere";

        String returnedString = game.peek(direction);

        assertTrue(returnedString.contains(expectedStringContent));
    }
    
    @Test
    /*
     * Test that looking in game successfully operates with 
     * item in location it will call the appropriate methods
     */
    public void testLookWithItemInRoom()
    {
        String item = "cats";
        Item mockItem = Mockito.mock(Item.class);
        when(mockItem.getName()).thenReturn(item);
        
        when(mockHouse.lookInCurrentRoom()).thenReturn(mockItem);
        
        Game game = new Game(mockPlayer, mockHouse);
        
        int expectedValue = 3;
        int returnValue = game.look();
        
        Mockito.verify(mockHouse).lookInCurrentRoom();
        assertTrue(expectedValue == returnValue);
    }
    
    @Test
    /*
     * Test that looking in game successfully operates with 
     * no item in location it will call the appropriate methods
     */
    public void testLookWithNothingInRoom()
    {
        when(mockHouse.lookInCurrentRoom()).thenReturn(null);
        
        Game game = new Game(mockPlayer, mockHouse);
        
        int expectedValue = -3;
        int returnValue = game.look();
        
        Mockito.verify(mockHouse).lookInCurrentRoom();
        assertTrue(expectedValue == returnValue);
    }
    
    @Test
    /*
     * Test that using item successfully operates when
     * player has item and they can also use that item 
     * in that particular location
     */
    public void testUseWithItem()
    {
        String item = "cats";
        Item mockItem = Mockito.mock(Item.class);
        when(mockItem.getName()).thenReturn(item);
        when(mockPlayer.hasItem(item)).thenReturn(true);
        when(mockHouse.canUseItemHere(item)).thenReturn(true);
        when(mockPlayer.useItem(item)).thenReturn(mockItem);
        
        Game game = new Game(mockPlayer, mockHouse);
        
        int expectedValue = 4;
        int returnValue = game.use(item);
        
        Mockito.verify(mockPlayer).hasItem(item);
        Mockito.verify(mockHouse).canUseItemHere(item);
        Mockito.verify(mockPlayer).useItem(item);
        
        assertTrue(expectedValue == returnValue);
    }
    
    @Test
    /*
     * Test that using item successfully operates when
     * player has item and they cannot use that item 
     * in that particular location
     */
    public void testUseWithItemCannotUseHere()
    {
        String item = "cats";
        when(mockPlayer.hasItem(item)).thenReturn(true);
        when(mockHouse.canUseItemHere(item)).thenReturn(false);
        
        Game game = new Game(mockPlayer, mockHouse);
        
        int expectedValue = -4;
        int returnValue = game.use(item);
        
        Mockito.verify(mockPlayer).hasItem(item);
        Mockito.verify(mockHouse).canUseItemHere(item);
        
        assertTrue(expectedValue == returnValue);
    }
    
    
    @Test
    /*
     * Test that using item successfully operates when
     * player has no item in inventory 
     */
    public void testUseWithNoItemInPlayerInventory()
    {
        String item = "cats";
        
        when(mockPlayer.hasItem(item)).thenReturn(false);
        
        Game game = new Game(mockPlayer, mockHouse);
        
        int expectedValue = -4;
        int returnValue = game.use(item);
        
        Mockito.verify(mockPlayer).hasItem(item);
        
        assertTrue(expectedValue == returnValue);
    }
    
}
