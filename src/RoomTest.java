import static org.junit.Assert.*;

import org.junit.Test;

import org.mockito.*;
import org.junit.Before;


public class RoomTest
{
    @Mock
    Trap mockTrap = Mockito.mock(Trap.class);
    Item mockItem = Mockito.mock(Item.class);
    String description;
    String peekDescription;
    String itemUsable;
    
    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(mockTrap);
        MockitoAnnotations.initMocks(mockItem);
        
        description = "You are in a room full of clowns with cat ears.";
        peekDescription = "Listening at the door, you hear cat sounds.";
        itemUsable = "peanut butter";
    }
    
    @Test
    public void testConstructorWithNoItemTrap()
    {
        Room room = new Room(description, peekDescription);
        
        assertTrue(room != null);
    }
    
    @Test
    public void testConstructorWithItemTrap()
    {
        Room room = new Room(description, peekDescription, mockItem, mockTrap, itemUsable);
        
        assertTrue(room != null);
    }
    
    
    
    
    

}
