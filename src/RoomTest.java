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
    public void testRoomGetExistingItemOnce()
    {
        String itemString = "cats";
        when(mockItem.toString()).thenReturn(itemString);
        
        Room room = new Room(description, peekDescription, mockItem, mockTrap, itemUsable);
        
        Item returnedItem = room.getItem();
        assertEquals(mockItem, returnedItem);
        assertEquals(itemString, returnedItem.toString());
    }
    
    @Test
    public void testRoomGetExistingItemTwice()
    {
        String itemString = "cats";
        when(mockItem.toString()).thenReturn(itemString);
        
        Room room = new Room(description, peekDescription, mockItem, mockTrap, itemUsable);
        
        Item returnedItem = room.getItem();
        assertEquals(mockItem, returnedItem);

        returnedItem = room.getItem();
        assertTrue(returnedItem == null);
    }
    
    @Test
    public void testRoomGetItemUsable()
    {
        Room room = new Room(description, peekDescription, mockItem, mockTrap, itemUsable);
        
        String expectedString = itemUsable;
        String returnedString = room.getItemUsable();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    public void testRoomWithTrapGetTrap()
    {
        Room room = new Room(description, peekDescription, mockItem, mockTrap, itemUsable);

        assertEquals(mockTrap, room.getTrap());
    }
    
    @Test
    public void testRoomWithoutTrapGetTrap()
    {
        Room room = new Room(description, peekDescription);

        assertEquals(null, room.getTrap());
    }
    
    @Test
    public void testRoomGetRoomInfo()
    {
        Room room = new Room(description, peekDescription);
        
        String expectedString = description;
        String returnedString = room.getRoomInfo();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    public void testRoomPeekInRoom()
    {
        Room room = new Room(description, peekDescription);
        
        String expectedString = peekDescription;
        String returnedString = room.peekInRoom();
        
        assertEquals(expectedString, returnedString);
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
