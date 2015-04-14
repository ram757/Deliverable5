import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class HouseTest
{
    //Declarations of variables to be used in class
    Room[][] gameboard;
    Room[][] nullGameboard;
    
    Trap trap;
    Item item;
    
    int numOfRows;
    int numOfCols;
    int startRow;
    int startCol;
    int endRow;
    int endCol;
    
    String roomInfo;
    String itemUsable;
    String peekInfo;
    String roomToString;
    
    @Before
    /*
     * Set up all dependencies so pre-determined output can be properly predicted
     */
    public void setUp()
    {
        //Initialize default values
        numOfRows = 5;
        numOfCols = 5;
        gameboard = new Room[numOfRows][numOfCols];
        nullGameboard = new Room[numOfRows][numOfCols];
        startRow = 0;
        startCol = 0;
        endRow = 4;
        endCol = 4;
        roomInfo = "This is room: ";
        itemUsable = "cats";
        peekInfo = "This is peeking room: ";
        roomToString = "To String of room: ";
        
        //Initialize Mocked trap
        trap = Mockito.mock(Trap.class);
        MockitoAnnotations.initMocks(trap);
        
        //Initialize Mocked item
        item = Mockito.mock(Item.class);
        MockitoAnnotations.initMocks(item);
        
        //Initialize mocked Room objects so all methods produce predetermined
        //Output independent of how those methods are to work inside of Room
        for(int i = 0; i < numOfRows; i++)
        {
            for(int j = 0 ; j < numOfCols; j++)
            {
                gameboard[i][j] = Mockito.mock(Room.class);
                MockitoAnnotations.initMocks(gameboard[i][j]);
                when(gameboard[i][j].getRoomInfo()).thenReturn(roomInfo + i + j);
                when(gameboard[i][j].getTrap()).thenReturn(trap);
                when(gameboard[i][j].hasTrap()).thenReturn(true);
                when(gameboard[i][j].getItem()).thenReturn(item);
                when(gameboard[i][j].hasItem()).thenReturn(true);
                when(gameboard[i][j].getItemUsable()).thenReturn(itemUsable);
                when(gameboard[i][j].peekInRoom()).thenReturn(peekInfo + i + j);
                when(gameboard[i][j].toString()).thenReturn(roomToString + i + j);
            }
        }
    }
    
    
    @Test
    /*
     * Test constructor given just a matrix of Room[][]
     */
    public void testHouseConstructorGivenBoard()
    {
        House house = new House(gameboard);
        
        assertNotNull(house);
    }
    
    @Test
    /*
     * Test constructor given matrix, start points and end points
     */
    public void testHouseConstructorGivenBoardAndExtraInfo()
    {
        House house = new House(gameboard, startRow, startCol, endRow, endCol);
        
        assertNotNull(house);
    }
    
    @Test
    /*
     * Test that getCurrentRoomInfo() will return the proper information 
     * when called at the origin
     */
    public void testHouseGetCurrentRoomInfoOrigin()
    {
        House house = new House(gameboard);
        
        String expectedString = roomInfo + "00";
        String returnedString = house.getCurrentRoomInfo();
        
        assertEquals(expectedString, returnedString);
    }

    @Test
    /*
     * Test that the current room info at point outside of origin
     * will return proper information when getCurrentRoomInfo() is
     * called
     */
    public void testHouseGetCurrentRoomInfoAtPoint()
    {
        int row = 3;
        int col = 3;
        
        House house = new House(gameboard, row, col, 0, 0);
        
        String expectedString = roomInfo + row + col;
        String returnedString = house.getCurrentRoomInfo();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    /*
     * Test that the House of null rooms returns expected String when trying
     * to get room information
     */
    public void testHouseGetCurrentRoomInfoAtNull()
    {
        House house = new House(nullGameboard);
        String expectedString = "Somehow you worked your way through a " +
                                "portal to hell.  Goodluck getting out.";
        
        String returnedString = house.getCurrentRoomInfo();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    /*
     * Make sure that hasFallenIntoTrap() will return the mocked Trap
     */
    public void testHouseHasFallenIntoTrap()
    {
        House house = new House(gameboard);
        
        Trap returnedTrap = house.hasFallenIntoTrap();
        
        assertNotNull(returnedTrap);
    }
    
    @Test
    /*
     * Test getSurroundingsInfo() from the origin to verify correct 
     * return String
     */
    public void testGetSurroundingsInfoFromOrigin()
    {
        House house = new House(gameboard, startRow, startCol, endRow, endCol);
        
        String expectedString = "You see a door: [south][east].";
        String returnedString = house.getSurroundingsInfo();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    /*
     * Test getSurroundingsInfo() from the point in middle of matrix 
     *  to verify correct return String
     */
    public void testGetSurroundingsInfoFromMiddlePoint()
    {
        int row = 2;
        int col = 2;
        House house = new House(gameboard, row, col, endRow, endCol);
        
        String expectedString = "You see a door: [south][north][east][west].";
        String returnedString = house.getSurroundingsInfo();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    /*
     * Test getSurroundingsInfo() in cell surrounded by null to verify correct
     * return String
     */
    public void testGetSurroundingsInfoFromRoomSurroundedByNull()
    {
        int row = 2;
        int col = 2;
        House house = new House(nullGameboard, row, col, endRow, endCol);
        
        String expectedString = "You see a door: NOWHERE... You're screwed.";
        String returnedString = house.getSurroundingsInfo();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    /*
     * Test that lookInCurrentRoom() works with room that has Item
     */
    public void testLookInCurrentRoomWithItem()
    {
        House house = new House(gameboard);
        
        Item returnedItem = house.lookInCurrentRoom();
        
        assertNotNull(returnedItem);
    }
    
    @Test
    /*
     * Test that lookInCurrentRoom() returns null when room itself is null
     */
    public void testLookInCurrentRoomThatIsNull()
    {
        House house = new House(nullGameboard);
        
        Item returnedItem = house.lookInCurrentRoom();
        
        assertNull(returnedItem);
    }
    
    @Test
    /*
     * Test that the correctly supplied item can be used 
     * in this particular room
     */
    public void testCanUseItemHereWithExistingItem()
    {
        String itemUsableHere = "cats";
        House house = new House(gameboard);
        
        boolean returnedValue = house.canUseItemHere(itemUsableHere);
        
        assertTrue(returnedValue);
    }
    
    @Test
    /*
     * Test that an incorrectly supplied item cannot be used 
     * in this particular room
     */
    public void testCanUseItemHereWithNonExistingItem()
    {
        String itemUnusableHere = "dogs";
        House house = new House(gameboard);
        
        boolean returnedValue = house.canUseItemHere(itemUnusableHere);
        
        assertFalse(returnedValue);
    }
    
    @Test
    /*
     * Test that an item is unfindable in a null room
     */
    public void testCanUseItemHereInNullRoom()
    {
        String itemUnfindable = "chickens";
        House house = new House(nullGameboard);
        
        boolean returnedValue = house.canUseItemHere(itemUnfindable);
        
        assertFalse(returnedValue);
    }
    
    @Test
    /*
     * Test that peekNorth() returns proper String if there is a room 
     * to the north of the current room
     */
    public void testPeekNorthToExisting()
    {
        int row = 2;
        int col = 2;
        
        House house = new House(gameboard, row, col, 0, 0);
        
        String expectedString = peekInfo + (row - 1) + col;
        String returnedString = house.peekNorth();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    /*
     * Test that peekSouth() returns proper String if there is a room 
     * to the south of the current room
     */
    public void testPeekSouthToExisting()
    {
        int row = 2;
        int col = 2;
        
        House house = new House(gameboard, row, col, 0, 0);
        
        String expectedString = peekInfo + (row + 1) + col;
        String returnedString = house.peekSouth();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    /*
     * Test that peekEast() returns proper String if there is a room 
     * to the east of the current room
     */
    public void testPeekEastToExisting()
    {
        int row = 2;
        int col = 2;
        
        House house = new House(gameboard, row, col, 0, 0);
        
        String expectedString = peekInfo + row + (col + 1);
        String returnedString = house.peekEast();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    /*
     * Test that peekWest() returns proper String if there is a room 
     * to the west of the current room
     */
    public void testPeekWestToExisting()
    {
        int row = 2;
        int col = 2;
        
        House house = new House(gameboard, row, col, 0, 0);
        
        String expectedString = peekInfo + row + (col - 1);
        String returnedString = house.peekWest();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    /*
     * Test that peekNorth() returns null if there is no room
     * to the north of the current room
     */
    public void testPeekNorthToNull()
    {
        int row = 2;
        int col = 2;
        
        House house = new House(nullGameboard, row, col, 0, 0);

        String returnedString = house.peekNorth();
        
        assertNull(returnedString);
    }
    
    @Test
    /*
     * Test that peekSouth() returns null if there is no room
     * to the south of the current room
     */
    public void testPeekSouthToNull()
    {
        int row = 2;
        int col = 2;
        
        House house = new House(nullGameboard, row, col, 0, 0);

        String returnedString = house.peekSouth();
        
        assertNull(returnedString);
    }
    
    @Test
    /*
     * Test that peekEast() returns null if there is no room
     * to the east of the current room
     */
    public void testPeekEastToNull()
    {
        int row = 2;
        int col = 2;
        
        House house = new House(nullGameboard, row, col, 0, 0);

        String returnedString = house.peekEast();
        
        assertNull(returnedString);
    }
    
    @Test
    /*
     * Test that peekWest() returns null if there is no room
     * to the west of the current room
     */
    public void testPeekWestToNull()
    {
        int row = 2;
        int col = 2;
        
        House house = new House(nullGameboard, row, col, 0, 0);

        String returnedString = house.peekWest();
        
        assertNull(returnedString);
    }

    @Test
    /*
     * Test that moveNorth() returns proper boolean if there is a room 
     * to the north of the current room
     */
    public void testMoveNorthExisting()
    {
        int row = 2;
        int col = 2;
        
        House house = new House(gameboard, row, col, 0, 0);

        boolean returnedValue = house.moveNorth();
        
        assertTrue(returnedValue);
    }
    
    @Test
    /*
     * Test that moveSouth() returns proper boolean if there is a room 
     * to the south of the current room
     */
    public void testMoveSouthExisting()
    {
        int row = 2;
        int col = 2;
        
        House house = new House(gameboard, row, col, 0, 0);

        boolean returnedValue = house.moveSouth();
        
        assertTrue(returnedValue);
    }
    
    @Test
    /*
     * Test that moveEast() returns proper boolean if there is a room 
     * to the east of the current room
     */
    public void testMoveEastExisting()
    {
        int row = 2;
        int col = 2;
        
        House house = new House(gameboard, row, col, 0, 0);

        boolean returnedValue = house.moveEast();
        
        assertTrue(returnedValue);
    }
    
    @Test
    /*
     * Test that moveWest() returns proper boolean if there is a room 
     * to the west of the current room
     */
    public void testMoveWestExisting()
    {
        int row = 2;
        int col = 2;
        
        House house = new House(gameboard, row, col, 0, 0);

        boolean returnedValue = house.moveWest();
        
        assertTrue(returnedValue);
    }
    
    @Test
    /*
     * Test that moveNorth() returns proper boolean if there is NOT a room 
     * to the north of the current room
     */
    public void testMoveNorthToNull()
    {
        int row = 2;
        int col = 2;
        
        House house = new House(nullGameboard, row, col, 0, 0);

        boolean returnedValue = house.moveNorth();
        
        assertFalse(returnedValue);
    }
    
    @Test
    /*
     * Test that moveSouth() returns proper boolean if there is NOT a room 
     * to the south of the current room
     */
    public void testMoveSouthToNull()
    {
        int row = 2;
        int col = 2;
        
        House house = new House(nullGameboard, row, col, 0, 0);

        boolean returnedValue = house.moveSouth();
        
        assertFalse(returnedValue);
    }
    
    @Test
    /*
     * Test that moveWest() returns proper boolean if there is NOT a room 
     * to the west of the current room
     */
    public void testMoveWestToNull()
    {
        int row = 2;
        int col = 2;
        
        House house = new House(nullGameboard, row, col, 0, 0);

        boolean returnedValue = house.moveWest();
        
        assertFalse(returnedValue);
    }
    
    @Test
    /*
     * Test that moveEast() returns proper boolean if there is NOT a room 
     * to the east of the current room
     */
    public void testMoveEastToNull()
    {
        int row = 2;
        int col = 2;
        
        House house = new House(nullGameboard, row, col, 0, 0);

        boolean returnedValue = house.moveEast();
        
        assertFalse(returnedValue);
    }
    
    @Test
    /*
     * Test that checkForEndRoom() properly returns false when not on the 
     * ending cell
     */
    public void testCheckForEndRoomNotAtEnd()
    {
        House house = new House(gameboard, startRow, startCol, endRow, endCol);
        
        boolean returnedValue = house.checkForEndRoom();
        
        assertFalse(returnedValue);
    }
    
    @Test
    /*
     * Test that checkForEndRoom() properly returns true when at the 
     * ending cell
     */
    public void testCheckForEndRoomAtEnd()
    {
        House house = new House(gameboard, endRow, endCol, endRow, endCol);
        
        boolean returnedValue = house.checkForEndRoom();
        
        assertTrue(returnedValue);
    }
    
}
