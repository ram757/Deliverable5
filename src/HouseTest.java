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
                when(gameboard[i][j].toString()).thenReturn(gameboard[i][j].getRoomInfo());
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
     * Test that the House of null rooms returns null when trying
     * to get room information
     */
    public void testHouseGetCurrentRoomInfoAtNull()
    {
        House house = new House(nullGameboard);
        
        assertNull(house.getCurrentRoomInfo());
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
    
    
}
