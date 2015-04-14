import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class HouseTest
{

    Room[][] gameboard;
    int numOfRows;
    int numOfCols;
    int startRow;
    int startCol;
    int endRow;
    int endCol;
    
    String roomInfo;
    Trap trap;
    Item item;
    String itemUsable;
    String peekInfo;
    
    @Before
    public void setUp()
    {
        //Initialize default values
        numOfRows = 5;
        numOfCols = 5;
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
    public void testHouseConstructorGivenBoard()
    {
        House house = new House(gameboard);
        
        assertNotNull(house);
    }
    
    @Test
    public void testHouseConstructorGivenBoardAndExtraInfo()
    {
        House house = new House(gameboard, startRow, startCol, endRow, endCol);
        
        assertNotNull(house);
    }
    
    

}
