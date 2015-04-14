import static org.junit.Assert.*;

import org.junit.Test;

import org.mockito.*;
import org.junit.Before;


public class RoomTest
{
    @Mock
    Trap mockTrap = Mockito.mock(Trap.class);
    Item mockItem = Mockito.mock(Item.class);
    Room room;
    
    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(mockTrap);
        MockitoAnnotations.initMocks(mockItem);
    }

}
