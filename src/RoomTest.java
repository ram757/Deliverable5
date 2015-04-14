import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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
    
    @Test
    public void testRoomHasItem()
    {
        Room room = new Room(description, peekDescription, mockItem, mockTrap, itemUsable);
        boolean expectedValue = true;
        boolean returnedValue = room.hasItem();
        
        assertEquals(expectedValue, returnedValue);
    }
    
    @Test
    public void testRoomHasTrap()
    {
        Room room = new Room(description, peekDescription, mockItem, mockTrap, itemUsable);
        boolean expectedValue = true;
        boolean returnedValue = room.hasTrap();
        
        assertEquals(expectedValue, returnedValue);
    }
    
    @Test
    public void testRoomToStringWithoutItemAndTrap()
    {
        String trapString = "Eaten by cats";
        String itemString = "unicycle";
        
        Room room = new Room(description, peekDescription);
        
        String expectedString = ("Room:\n\tDescription: " + description);
        
        String returnedString = room.toString();
        
        assertEquals(expectedString, returnedString);
    }
    
    
    @Test
    public void testRoomToStringWithItemAndTrap()
    {
        String trapString = "Eaten by cats";
        String itemString = "unicycle";
        
        when(mockItem.toString()).thenReturn(itemString);
        when(mockTrap.toString()).thenReturn(trapString);
        
        Room room = new Room(description, peekDescription, mockItem, mockTrap, itemUsable);
        
        String expectedString = ("Room:\n\tDescription: " +
                                description +
                                "\n\tTrap: " + trapString +
                                "\n\tItem: " + itemString +
                                "\n\tItem Usable: " + itemUsable);
        
        String returnedString = room.toString();
        
        assertEquals(expectedString, returnedString);
    }
    
    
    
    
    

}
