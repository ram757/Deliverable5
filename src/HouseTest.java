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
    
    @Before
    public void setUp()
    {
        numOfRows = 5;
        numOfCols = 5;
        startRow = 0;
        startCol = 0;
        endRow = 4;
        endCol = 4;
        
        for(int i = 0; i < numOfRows; i++)
        {
            for(int j = 0 ; j < numOfCols; j++)
            {
                gameboard[i][j] = Mockito.mock(Room.class);
                MockitoAnnotations.initMocks(gameboard[i][j]);
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
