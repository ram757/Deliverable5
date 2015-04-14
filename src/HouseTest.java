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
    int numOfRows = 5;
    int numOfCols = 5;
    
    @Before
    public void setUp()
    {
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
        fail("Not yet implemented");
    }

}
